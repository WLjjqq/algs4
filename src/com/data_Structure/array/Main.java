package com.data_Structure.array;
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        char[] chars = s1.toCharArray();
        chars[5] = ',';
        System.out.println(chars);
    }
}