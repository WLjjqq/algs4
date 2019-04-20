package com.data_Structure.string;

public class ChangeString {
    public static void main(String[] args) {
        /**
         * 在 Java 中，由于字符串是不可变的，因此在连接时首先为新字符串分配足够的空间，复制旧字符串中的内容并附加到新字符串。
         * 总时间复杂度是O(n2) n的2次方。
         */
        String s = "";
        int n = 10000;
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
        System.out.println(s);
        /**
         * 解决方案：1：如果你确实希望你的字符串是可变的，则可以将其转换为字符数组。
         */
        String s1 = "Hello World";
        char[] str = s1.toCharArray();
        str[5] = ',';
        System.out.println(str);
        /**
         * 解决方案：2： 如果你经常必须连接字符串，最好使用一些其他的数据结构，如 StringBuilder 。 以下代码以 O(n) 的复杂度运行。
         */
        int l = 10000;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            stb.append("hello");
        }
        String string = str.toString();
        System.out.println(string.toString());
    }
}
