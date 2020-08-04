package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 上午10:07
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: `
 * `          Say you have an array for which the ith element is the price of a given stock on day i.
 * `          If you were only permitted to complete at most one transaction
 * `          (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * `          Note that you cannot sell a stock before you buy one.
 * `
 * `          假设您有一个数组，第i个元素是第i天给定股票的价格。
 * `          如果您只被允许最多完成一笔交易
 * `          （即，买入并卖出一股股票），设计一种算法以找到最大的利润。
 * `          请注意，您不能在买股票之前卖出股票。
 * `
 * `      Example 1:
 * `          Input: [7,1,5,3,6,4]
 * `          Output: 5
 * `          Explanation:
 * `              Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * `              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * `      Example 2:
 * `          Input: [7,6,4,3,1]
 * `          Output: 0
 * `          Explanation:
 * `              In this case, no transaction is done, i.e. max profit = 0.
 * @Version: 1.0
 */
public class _121_best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                profit = Math.max(prices[i] - buy,profit);
            } else {
                buy = prices[i];
            }
        }

        return profit;
    }


}
