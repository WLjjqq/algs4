package com.String;

public class Test {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = "HelloWorld";
        String str3 = new String("HelloWorld");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

        String str4 = "lulu";
        str4 = str4 + "fangfang";
        System.out.println(str4);    //输出结果：lulufangfang
        String str5 = "ad";
        String str6 = "aa";
        System.out.println(str5.compareTo(str6)); //输出3
        String str7 = "adcdefabcdef";
        System.out.println(str7.indexOf("d",4)); //输出9
        String str8 = "adcdefabcdef";
        System.out.println(str8.lastIndexOf("d",5)); //输出3
        String str9 = "abc";
        String str10 = "abcd";
        System.out.println(str9.startsWith("a")); //输出true
        System.out.println(str10.endsWith("d"));  //输出true
        String str11 = "abc";
        String str12 = "abcd";
        System.out.println(str12.regionMatches(0,str11,1,2)); //输出true

        System.out.println(str12.substring(2)); //输出cd
        System.out.println(str12.substring(0,2)); //输出ab
        System.out.println(2<<8);
        System.out.println(9>>3);
    }
}
