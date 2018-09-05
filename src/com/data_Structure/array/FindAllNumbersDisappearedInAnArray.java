package com.data_Structure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *      appear 英 /ə'pɪə/ 出现。
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *     inclusive  英 /ɪn'kluːsɪv/ 包括的，包含的。
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {
    /**
     * 利用了Map的Key 和Value 先把所有的都放Map中。然后判断存在不。如果不存在的就放到list中。
     * */
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            map.put(i,1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], -1);
            }
        }

        for(int i: map.keySet()) {
            if(map.get(i) != -1) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[]={4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = FindAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        for (Integer i : disappearedNumbers) {
            System.out.println(i);
        }
    }
}
