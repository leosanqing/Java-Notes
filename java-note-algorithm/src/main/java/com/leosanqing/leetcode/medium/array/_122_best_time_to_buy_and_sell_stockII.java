package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 上午10:23
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Say you have an array prices for which the ith element is the price of a given stock on day i.
 * `          Design an algorithm to find the maximum profit.
 * `          You may complete as many transactions as you like
 * `          (i.e., buy one and sell one share of the stock multiple times).
 * `          Note: You may not engage in multiple transactions at the same time
 * `          (i.e., you must sell the stock before you buy again).
 * `      Example 1:
 * `          Input: [7,1,5,3,6,4]
 * `          Output: 7
 * `          Explanation:
 * `              Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * `              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * `      Example 2:
 * `          Input: [1,2,3,4,5]
 * `          Output: 4
 * `          Explanation:
 * `              Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * `              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * `              engaging multiple transactions at the same time. You must sell before buying again.
 * `      Example 3:
 * `          Input: [7,6,4,3,1]
 * `          Output: 0
 * `          Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * @Version: 1.0
 */
public class _122_best_time_to_buy_and_sell_stockII {
    public static void main(String[] args) {
        int[] ints = {7, 6, 4, 3, 1};
        maxProfit(ints);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 只要 后面的大于前面的就继续往后，
            if (prices[i] > prices[i - 1]) {
                // 如果是最后一个 如[1,2,3,4,5]，当他到5的时候，就要卖出了  不然就是0
                if (i == prices.length - 1) {
                    profit += prices[i] - buy;
                }
                continue;
            }
            // 不然就 计算前面的利润  如 [1,2,5,3] 当我们 到 3 的时候，我们就要计算 5-1 的利润
            profit += prices[i - 1] - buy;
            buy = prices[i];
        }

        return profit;
    }
}
