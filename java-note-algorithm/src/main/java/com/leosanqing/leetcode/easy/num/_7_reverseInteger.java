package com.leosanqing.leetcode.easy.num;

/**
 * @Author: rtliu
 * @Date: 2020/7/3 下午3:19
 * @Package: com.leosanqing.leetcode.easy.num
 * @Description: `    Given a 32-bit signed integer, reverse digits of an integer.
 * ` Example 1:
 * `    Input: 123
 * `    Output: 321
 * ` Example 2:
 * `    Input: -123
 * `    Output: -321
 * ` Example 3:
 * `    Input: 120
 * `    Output: 21
 * ` Note:
 * `    Assume we are dealing with an environment which could only store integers
 * `    within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * `    assume that your function returns 0 when the reversed integer overflows.
 * @Version: 1.0
 */
public class _7_reverseInteger {
    public static void main(String[] args) {
        _7_reverseInteger reverseInteger = new _7_reverseInteger();
        System.out.println(reverseInteger.reverse(-1200));
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
