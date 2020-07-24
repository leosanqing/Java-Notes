package com.leosanqing.leetcode.medium;

/**
 * @Author: rtliu
 * @Date: 2020/6/1 上午10:45
 * @Package: medium
 * @Description: `
 * `      Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * `      return the bitwise AND of all numbers in this range, inclusive.
 * `
 * `      给定一个范围
 * `      返回这个范围内的所有数字的 按位与 的 和
 * `
 * `   Example 1:
 * `
 * `      Input: [5,7]
 * `      Output: 4
 * `   Example 2:
 * `
 * `      Input: [0,1]
 * `      Output: 0
 * `
 * `
 * @Version: 1.0
 */
public class _201_bitwiseANDOfNumbersRange {

    public static void main(String[] args) {

        System.out.println(solution(5, 12));

        System.out.println(solution(5, 12));
    }


    /**
     * 思路很简单，只要从 m 到 n 的任意一个数字中的一位是0， 那么那一位 不管怎么 & 都是0
     * 比如 [5-12]
     * 5    101
     * 6    110
     * 7    111
     * 8   1000
     * 9   1001
     * 10   1010
     * 11   1011
     * 12   1010
     * <p>
     * 我们看 只要我们找到他的最前面几位是一样的时候，再给他补完后面的位数，就找到了
     *
     * @param m
     * @param n
     * @return
     */
    private static int solution(int m, int n) {
        int step = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            step++;
        }
        return m << step;
    }
}
