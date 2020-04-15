package easy;

/**
 * 描述：  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例1： 输入: [7,1,5,3,6,4]
 *        输出: 7
 *        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例2： 输入: [1,2,3,4,5]
 *        输出: 4
 *        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *        注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *        因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 思路：使用两个变量 一个valley表示当天天数中最低价，
 *                 一个peek表示当前所有的天数中的最高价
 *      因为我们可以买卖股票且是不用付手续费的，也就是我们可以卖了这一只股票，然后再把它买回来
 *      所以上面示例2中，5-1和 （2-1）+（3-2）+（4-3）+（5-4）的效果是一样的，所以顶峰就找递增的，底就找递减的
 *
 */
public class _122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null)
            return 0;
        int valley = prices[0],peek = prices[0];
        int i =0;
        int maxProfit = 0;
        while(i < prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            valley = prices[i];
            while(i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            peek = prices[i];
            maxProfit += peek-valley;
            }
        
        return maxProfit;
        }
    }