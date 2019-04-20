package com.data_Structure.array;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 2, 4};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                //交换位置
                int temp=arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1]=temp;
            }
        }
    }
}
