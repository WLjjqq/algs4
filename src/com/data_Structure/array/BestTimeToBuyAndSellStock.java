package com.data_Structure.array;
// Say you have an array for which the ith element is the price of a given stock on day i.
/** given stock  给定的股票 **/
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
/** permitted 允许  complete 完整的 transaction 交易*/
// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
    /** difference 区别 selling 销售，售出 larger 大的，多量的**/
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.
//假设有一个数组，其中第i个元素是第i天给定股票的价格。
//如果你最多只能完成一笔交易(比如，买一股，卖一股)，设计一个算法来找到最大的利润。
//示例1:
// 输入:[7,1,5,3,6,4]
        //输出:5
// max。差= 6-1 = 5(不是7-1 = 6，因为卖价需要大于买价)
//示例2:
//输入:[7,6,4,3,1]
        //输出:0
//在这种情况下，没有进行任何交易，即最大利润= 0。
public class BestTimeToBuyAndSellStock {
        public static int maxProfit(int[] prices){
            if(prices.length==0){
                return 0;
            }
            int min=prices[0];
            int max=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>min){
                    max = Math.max(max,prices[i]-min);
                }else {
                    min = prices[i];
                }
            }
            return max;
        }
        public static void main(String[] args) {
            int prices[]={4,1,5,3,6,7};
            int i = BestTimeToBuyAndSellStock.maxProfit(prices);
            System.out.println(i);
            //输出的是7 因为最后卖的是6   int prices[]={7,1,5,3,6,4};输出的是5
        }
}
