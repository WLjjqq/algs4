package com.data_Structure.array;

/**
 * 递归。简单来说就是自己调用自己。无限循环。
 * 但是要掌握好跳出循环的条件。不然你的程序就是死程序了。一直调用。直到把你的内存消耗完。
 * n!=n*(n-1)*(n-2)*...*1
 */
public class Recursion {
    public static void main(String[] args) {
        int recursion = recursion(5);
        System.out.println(recursion);
    }
    public static int recursion(int i){
        int sum;
        if (i == 0) {
            return 1;
        } else {
            sum = i * recursion(i - 1);
        }
        return sum;
    }
}
