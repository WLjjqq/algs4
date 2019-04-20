package com.reflact;

public class Person {
    public String name;
    private int age;
    private final   String aa="aabbccdd";
    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", aa='" + aa + '\'' +
                '}';
    }

    private void show(){
        System.out.println("我是一个私有方法，没有钥匙不能调用我啊!!!");
    }
    public void showPub() {
        System.out.println("我是一个任何人都能调用的方法。");
    }
}
