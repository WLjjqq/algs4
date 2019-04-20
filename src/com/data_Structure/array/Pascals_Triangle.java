package com.data_Structure.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class Pascals_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  ans=new ArrayList<List<Integer>>();
        if(numRows<=0){
            return ans;
        }else{
            List<Integer> bns=new ArrayList<Integer>();
            bns.add(1);
            ans.add(bns);

            for(int i=1;i<numRows;i++){
                List<Integer> temp=ans.get(i-1);
                LinkedList<Integer> link=new LinkedList<Integer>();
                link.addFirst(1);
                for(int j=1;j<i;j++){
                    link.addFirst(temp.get(j-1)+temp.get(j));
                }
                link.addFirst(1);
                ans.add(link);

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = Pascals_Triangle.generate(5);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
