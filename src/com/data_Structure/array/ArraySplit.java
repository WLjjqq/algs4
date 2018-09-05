package com.data_Structure.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 */
public class ArraySplit {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        for (int i=0;i<nums.length;i+=2){
            list1.add(nums[i]);
        }
        int sum=0;
        for (int j=0;j<list1.size();j++){

            sum +=list1.get(j);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={1,4,3,2,7,9};
        int i = ArraySplit.arrayPairSum(nums);
        System.out.println(i);
    }
}
