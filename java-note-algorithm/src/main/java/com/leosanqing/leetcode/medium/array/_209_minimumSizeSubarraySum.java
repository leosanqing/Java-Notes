package com.leosanqing.leetcode.medium.array;

/**
 * @Author: rtliu
 * @Date: 2020/6/17 下午2:38
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description:
 *      Given an array of n positive integers and a positive integer s,
 *      find the minimal length of a contiguous subarray of which the sum ≥ s.
 *      If there isn't one, return 0 instead.
 *
 *      给定一个只有正整数的数组和一个正整数 s
 *      返回 子数组之和大于 s 的长度
 *      如果没有，则返回 0
 *
 *
 *      Example:
 *
 *      Input: s = 7, nums = [2,3,1,2,4,3]
 *      Output: 2
 *      Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 *
 *
 * @Version: 1.0
 */
public class _209_minimumSizeSubarraySum {

    public static void main(String[] args) {
        int a[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,a));
    }

    /**
     * 使用滑动窗口，设置两个指针 i 和 j 充当窗口的界限
     * @param s
     * @param a
     * @return
     */
    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        // 在数组范围内
        while (j < a.length) {

            sum += a[j++];
            // 如果和大于 s，就从前开始挨个减去
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
