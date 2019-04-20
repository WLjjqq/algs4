package com.String;

public class TestStringBuffer {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(123).append(456);
        System.out.println(stringBuffer); //输出123456
        stringBuffer.insert(3,789);
        System.out.println(stringBuffer);  //输出123789456
        StringBuffer stringBuffer1 = new StringBuffer("abc");
        System.out.println(stringBuffer1.reverse()); //输出cba
        System.out.println(stringBuffer1.delete(0,2)); //输出a 从下标0开始。删除两个。
        StringBuffer stringBuffer2 = new StringBuffer("abcd");
        stringBuffer2.setCharAt(1,'e');
        System.out.println(stringBuffer2);   //输出 aecd
        StringBuffer stringBuffer3 = new StringBuffer("abcdefg");
        stringBuffer3.replace(0, 2, "xyz");
        System.out.println(stringBuffer3); //输出 xyzcdefg
    }
}
