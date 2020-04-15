package easy;

/**
 *描述 ：    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *          如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *          注意你不能在买入股票前卖出股票。
 *
 *示例1：    输入: [7,1,5,3,6,4]
 *          输出: 5
 *          解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *          注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 *示例2      输入: [7,6,4,3,1]
 *          输出: 0
 *          解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class _121_BestTimeToBuyAndSellStock {

    /**
     *
     * 直接暴力求解，遍历两次数组，求出最优解
     */

    public static int violence(int[] prices){
        if(prices == null || prices.length ==0){
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]-prices[i] >maxProfit){
                    maxProfit = prices[j]-prices[i];
                }

            }
        }
        return maxProfit;
    }


    /**
     *  动态规划：
     *      1.定义一个从最开始到当前位置的最小值
     *      2.计算今天减去最小值的值，也就是当天的利润
     *      3.比较当天的利润和之前的最大利润
     */
    public static int dp(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;

        int mixProfit = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            //找到最小值
            mixProfit = Math.min(mixProfit,prices[i]);
            //比较当天的利润和最大利润
            maxProfit = Math.max(maxProfit,(prices[i]-mixProfit));

        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int a[] ={7,6,4,3,1};
        System.out.println(violence(a) == dp(a));
    }
}
