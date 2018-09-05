package com.data_Structure.array;
import java.util.Arrays;

public class FindMaximums {
    public static int dominantIndex(int[] nums) {
        //解题思路：先克隆一个数组。然后对原数组进行排序。如果最后一个大于倒数第二个的二倍，就成立。
        // 然后和克隆的那个数组去对比，查找这个值在克隆数组的哪个地方。
        int[] nums2=nums.clone();
        //对数组进行快速排序。
        Arrays.sort(nums);
        if(nums[nums.length-1]/2>=nums[nums.length-2]){
            int max=nums[nums.length-1];
            for(int i=0;i<=nums2.length;i++){
                if(max == nums2[i]){
                    return i;
                }
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,6,0};
        int i = FindMaximums.dominantIndex(nums);
        System.out.println(i);
    }
}
