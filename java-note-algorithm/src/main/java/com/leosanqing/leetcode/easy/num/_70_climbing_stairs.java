package com.leosanqing.leetcode.easy.num;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午2:26
 * @Package: com.leosanqing.leetcode.easy.num
 * @Description: 1
 * `          You are climbing a stair case.
 * `          It takes n steps to reach to the top.
 * `          Each time you can either climb 1 or 2 steps.
 * `          In how many distinct ways can you climb to the top?
 * `      Example 1:
 * `          Input: 2
 * `          Output: 2
 * `          Explanation:
 * `              There are two ways to climb to the top.
 * `              1. 1 step + 1 step 2. 2 steps
 * `      Example 2:
 * `          Input: 3
 * `          Output: 3
 * `          Explanation:
 * `              There are three ways to climb to the top.
 * `              1. 1 step + 1 step + 1 step
 * `              2. 1 step + 2 steps
 * `              3. 2 steps + 1 step
 * @Version: 1.0
 */
public class _70_climbing_stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }

    /**
     * 仔细看这个题 其实是斐波那契数列的变种，解题方法一致
     *
     * 我们可以使用栈，也可以使用 DP，但是 DP明显优于栈
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int pre = 3;
        int prePre = 2;
        int cur = 0;
        for (int i = 4; i <= n; i++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }

        return cur;
    }
}
