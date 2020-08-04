package com.leosanqing.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 下午5:43
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * `          Given a string s, partition s such that every substring of the partition is a palindrome.
 * `          Return all possible palindrome partitioning of s.
 * `      Example:
 * `          Input: "aab"
 * `          Output:
 * `              [
 * `                  ["aa","b"],
 * `                  ["a","a","b"]
 * `              ]
 * @Version: 1.0
 */
public class _131_palindrome_partitioning {
    public static void main(String[] args) {
        partition("aab");
    }
    public static List<List<String>> partition(String s) {

        List<List<String>> answer = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            backTrace(answer,new ArrayList<>(), s, 0, i);
        }
        return answer;
    }

    private static void backTrace(List<List<String>> answer, List<String> list, String s, int position, int length) {
        if (position >= s.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }


        String substring = s.substring(position, position + length);
        if (isPalindrome(substring)) {
            list.add(substring);
            return;
        }
        backTrace(answer, list, s, position + length, length);
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
