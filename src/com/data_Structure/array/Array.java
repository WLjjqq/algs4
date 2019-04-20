package com.data_Structure.array;

/**
 * 2018年11月7日   学习一下数组的增删改查
 */
public class Array {

    public static int[] insert(int[] array,int i,int l){
        //创建一个新的数组。
        int new_array[] =new int[array.length+1];
        //把旧的数组赋值给新的数组
        for(int j=0;j<array.length;j++){
            new_array[j]=array[j];
        }
        //i 是要插入的下标位置。把大于i的都给往后移一个位置。
        for(int j=new_array.length-2;j>=i;j--){
            new_array[j+1]=new_array[j];

        }
        //l  是要插入的值。插入到i
        new_array[i]=l;
        return new_array;
    }

    //index是要删除的下标位置
    public static int[] delete(int[] array,int index){
        int new_array[] = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (i < index) {
                new_array[i] = array[i];
            } else {
                new_array[i] = array[i + 1];
            }

        }
        return new_array;
    }

    public static void main(String[] args) {
        //测试添加
        int arr[] = {1,3,4};
        int arr1[] = insert(arr,2,6);
        for(int i:arr1){
            System.out.println("添加后的值："+i);
        }

        int arr2[] = delete(arr,1);
        for(int i :arr2){
            System.out.println("删除后遍历数组："+i);
        }

        //修改
        arr[2]=9;
        //查询
        System.out.println("查询下标为2的值："+arr[2]);
    }


}
