package com.data_Structure.array;

import java.util.HashMap;

/**Given an array of integers and an integer k, find out whether there are two distinct indices i and
j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 给定一个整数数组和一个整数k，找出是否有两个不同的指标i和j在数组中，
 使number [i] = nums[j]，并且i和j之间的绝对差不超过k。
 indices ：英 /'ɪndɪsiːz/  指数哦，目录
 absolute 英 /'æbsəluːt/  绝对的。完全的。
 */
public class ContainsDuplicatesII {
    public static boolean containsNearbyDuplicate(int nums[],int k){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            //containsKey 查看map中是否有这个元素。
            if(map.containsKey(current) && i-map.get(current)<=k){
                return true;
            }else {
                map.put(current,i);
            }
            System.out.println(current);
            System.out.println(map.get(current));
        }
        return false;

    }

    public static void main(String[] args) {
        int nums[] ={2,2,3,5,7,7,7,7,7};
        boolean b = ContainsDuplicatesII.containsNearbyDuplicate(nums, 4);
        System.out.println(b);

    }
}
