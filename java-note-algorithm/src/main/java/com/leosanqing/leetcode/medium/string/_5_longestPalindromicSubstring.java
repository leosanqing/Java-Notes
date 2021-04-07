package com.leosanqing.leetcode.medium.string;

/**
 * @Author: rtliu
 * @Date: 2020/7/3 上午11:16
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: ` `    Given a string s, find the longest palindromic substring in s.
 * ` `    You may assume that the maximum length of s is 1000.
 * `
 * ` `    给定字符串s，找到s中最长的回文子字符串。
 * `      您可以假设s的最大长度为1000。
 * ` `  Example 1:
 * ` `    Input: "babad"
 * ` `    Output: "bab"
 * ` `    Note: "aba" is also a valid answer.
 * ` `  Example 2:
 * ` `    Input: "cbbd"
 * ` `    Output: "bb"
 * @Version: 1.0
 */
public class _5_longestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abasasaiug";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String longStr = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = findStr(s, i, i);
            String s2 = findStr(s, i, i + 1);

            if (s1.length() > longStr.length()) {
                longStr = s1;
            }
            if (s2.length() > longStr.length()) {
                longStr = s2;
            }
        }

        return longStr;
    }

    private static String findStr(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
