package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-16 18:42
 *
 * 面试题 10 斐波那契数列
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class _10_Fibonacci {
    public static void main(String[] args) {

//        System.out.println(method1(50);
        System.out.println(method1(40) == method2(40));
    }


    /**
     * 采用递归的思想，这种最常见但是效率极低。
     * 并且会有栈溢出的情况
     *
     * @param n
     * @return
     */
    private static long method1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return method1(n - 1) + method1(n - 2);
    }


    /**
     * 我们只需要知道两个数，要计算当前的就只要知道他前面的两个数。
     * 我们只要每次计算这两个就行。
     *
     * 这样时间复杂度就是 O(n)
     * @param n
     * @return
     */
    private static long method2(int n) {
        int[] nums = {0, 1};

        if (n < 2) {
            return nums[n];
        }
        // 前面的数 n-2
        long one = 1;
        // 第二个数 n-1
        long two = 0;
        // 当前数
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = one + two;
            two = one;
            one = fibN;
        }
        return fibN;
    }

}
