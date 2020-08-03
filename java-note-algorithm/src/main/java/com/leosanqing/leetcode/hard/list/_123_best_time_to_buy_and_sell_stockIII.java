package com.leosanqing.leetcode.hard.list;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 上午10:57
 * @Package: com.leosanqing.leetcode.hard.list
 * @Description: 1
 * `          Say you have an array for which the ith element is the price of a given stock on day i.
 * `          Design an algorithm to find the maximum profit.
 * `          You may complete at most two transactions.
 * `          Note: You may not engage in multiple transactions at the same time
 * `          (i.e., you must sell the stock before you buy again).
 * `      Example 1:
 * `          Input: [3,3,5,0,0,3,1,4]
 * `          Output: 6
 * `          Explanation:
 * `              Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * `              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * `      Example 2:
 * `          Input: [1,2,3,4,5]
 * `          Output: 4
 * `              Explanation:
 * `              Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * `          Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * `          engaging multiple transactions at the same time. You must sell before buying again.
 * `      Example 3:
 * `          Input: [7,6,4,3,1]
 * `          Output: 0
 * `          Explanation:
 * `              In this case, no transaction is done, i.e. max profit = 0.
 * @Version: 1.0
 */
public class _123_best_time_to_buy_and_sell_stockIII {
    public static void main(String[] args) {

        maxProfit(new int[]{1, 2, 3, 4, 5});
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int totalK = 2;
        int[][] dp = new int[totalK + 1][prices.length];
        for (int k = 1; k <= totalK; k++) {
            //profit = 0 when k = 0
            for (int i = 1; i < prices.length; i++) {
                //buy on day 0, sell on day i
                int maxProfitSellOnDayI = Math.max(0, prices[i] - prices[0]);
                //buy on day j, sell on day i
                for (int j = 1; j < i; j++) {
                    maxProfitSellOnDayI = Math.max(maxProfitSellOnDayI, dp[k - 1][j - 1] + prices[i] - prices[j]);
                }
                //sell on day i OR not
                dp[k][i] = Math.max(dp[k][i - 1], maxProfitSellOnDayI);
            }
        }
        return dp[totalK][prices.length - 1];

    }
}
