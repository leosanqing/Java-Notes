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
        _5_longestPalindromicSubstring substring = new _5_longestPalindromicSubstring();
        String s = "abasasaiug";
        System.out.println(substring.longestPalindrome(s));
    }

    private String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String maxStr = "";


        for (int i = 0; i < s.length(); i++) {
            // s1 表示 sas 这种 ，s2 表示 saas 这种
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (maxStr.length() < s1.length()) {
                maxStr = s1;
            }
            if (maxStr.length() < s2.length()) {
                maxStr = s2;
            }
        }


        return maxStr;
    }


    /**
     * 以 i j 为中心，对称找回文
     * @param s 输入的字符串
     * @param i
     * @param j
     * @return
     */
    private String extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
