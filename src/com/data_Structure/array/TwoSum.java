package com.data_Structure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //利用HashMap,key存储值，value存储下标。i=0  x=nums[0]，map为空。然后存放到map中。
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(map.containsKey(target-x)){
                int[] ints = {map.get(target - x), i};
                System.out.println(ints[0]+" "+ints[1]);
                return ints;
            }
            map.put(x, i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }
   public static void main(String[] args) {
       int[] nums = { 2,7,11, 15};
       TwoSum twoSum=new TwoSum();

       int[] ints = twoSum.twoSum(nums, 9);
       System.out.println(ints.toString());
   }
}
