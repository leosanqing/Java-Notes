package com.leosanqing.leetcode.easy.num;

/**
 * @Author: rtliu
 * @Date: 2020/7/3 下午3:24
 * @Package: com.leosanqing.leetcode.easy.num
 * @Description: `
 * `     Determine whether an integer is a palindrome.
 * `     An integer is a palindrome when it reads the same backward as forward.
 * `
 * `  Example 1:
 * `     Input: 121
 * `     Output: true
 * `  Example 2:
 * `     Input: -121
 * `     Output: false
 * `     Explanation:
 * `         From left to right, it reads -121.
 * `         From right to left, it becomes 121-.
 * `         Therefore it is not a palindrome.
 * `  Example 3:
 * `     Input: 10
 * `     Output: false
 * `     Explanation:
 * `         Reads 01 from right to left. Therefore it is not a palindrome.
 * @Version: 1.0
 */
public class _9_palindrome_number {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    public static boolean isPalindrome(int x) {
        // 如果小于0 或者大于零 但是以0结尾的都不是
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        // 只需要一半，就可以进行匹配
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == x || x == rev / 10;
    }

    /**
     * 使用字符串
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        // 如果小于0 或者大于零 但是以0结尾的都不是
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        String s = String.valueOf(x);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
