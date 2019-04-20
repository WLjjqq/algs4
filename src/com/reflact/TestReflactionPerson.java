package com.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射去调用Person这个类
 */
public class TestReflactionPerson {
    public static void main(String[] args) throws Exception {
        after();
    }

    /**
     * 在使用反射以前，如何创建一个类的对象。并调用其中的方法和属性。
     */
    public static void before(){
        Person person = new Person();
        person.setName("L");
        person.setAge(19);
        System.out.println(person);
    }

    public static void after() throws Exception {
        Class<?> c = Class.forName("com.reflact.Person");
        System.out.println(c.getName()); //输出：com.reflact.Person
        //参数类型的数组。
        Class[] aa = {String.class,int.class};
        //根据参数类型的数组得到是哪个构造器
        Constructor<?> constructor = c.getConstructor(aa);
        //然后利用这个构造器去创建相应的实例
        Person person2 = (Person) constructor.newInstance("lulu",20);
        Person person3 = (Person) constructor.newInstance("doudou",19);
        System.out.println(person2);        //输出：Person{name='lulu', age=20}
        Field[] fields = c.getFields();
        Field[] declaredFields = c.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("获取的属性："+field);
        }
        //利用反射得到相应的私有属性。然后去修改它。
        Field age = c.getDeclaredField("age");
        //使其变为可访问
        age.setAccessible(true);
        age.set(person2,40);
        System.out.println("露露："+person2);

        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("包含父类的方法："+method);
        }
        Method show = c.getMethod("showPub");
        show.setAccessible(true);
        Object invoke = show.invoke(person2);
        System.out.println("invoke:"+invoke);
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor constructor1 : constructors) {
            System.out.println("构造器1："+constructor1);
        }
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor constructor2 : declaredConstructors) {
            System.out.println("构造器2："+constructor2);
        }

        Field aa1 = c.getDeclaredField("aa");
        aa1.setAccessible(true);

        aa1.set(person2,"abcd");
        System.out.println("aa1:"+person2);
    }

    /**
     * 如何获取Class的实例
     */
    public static void get_Class() throws  Exception {
        //1：直接调用运行时类本身的.class属性
        Class<Person> a = Person.class;
        System.out.println(a.getName()); //输出：com.reflact.Person
        Person person1 = a.newInstance();
        person1.setName("lu");
        person1.setAge(22);
        System.out.println(person1);  //输出：Person{name='lu', age=22}
        //2:通过运行时类的对象获取
        Person person = new Person();
        Class<? extends Person> b = person.getClass();
        System.out.println(b.getName());   //输出：com.reflact.Person
        //3:通过Class的静态方法获取
        Class<?> c = Class.forName("com.reflact.Person");
        System.out.println(c.getName()); //输出：com.reflact.Person
    }
}
