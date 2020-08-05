package com.leosanqing.leetcode.medium.num;

/**
 * @Author: rtliu
 * @Date: 2020/6/23 下午4:17
 * @Package: com.leosanqing.leetcode.medium.num
 * @Description: Write a program to find the n-th ugly number.
 *              Ugly numbers are positive numbers whose prime factors
 * only include 2, 3, 5.
 * @Version: 1.0
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 *   n does not exceed 1690.
 */
public class _264_uglyNumberII {
    public int nthUglyNumber(int n) {

        // 创建一个数组，用来存储 uglyNumber
        int[] ugly = new int[n];
        ugly[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            // 如果 这个数字是他的倍数，那就往后走，
            // 比如 30 是 2 3 5 的共同的 uglyNumber，所以他们都要往后移一个
            if (factor2 == min) {
                factor2 = 2 * ugly[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++index5];
            }
        }
        return ugly[n - 1];
    }



}
