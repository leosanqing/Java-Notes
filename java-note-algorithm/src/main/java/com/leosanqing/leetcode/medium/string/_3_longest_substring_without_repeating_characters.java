package com.leosanqing.leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * 给定字符串s，找到最长子字符串的长度而不重复字符。
 * <p>
 * ` Example 1:
 * <p>
 * ` Input: s = "abcabcbb"
 * ` Output: 3
 * ` Explanation: The answer is "abc", with the length of 3.
 * ` Example 2:
 * <p>
 * ` Input: s = "bbbbb"
 * ` Output: 1
 * ` Explanation: The answer is "b", with the length of 1.
 * ` Example 3:
 * <p>
 * ` Input: s = "pwwkew"
 * ` Output: 3
 * ` Explanation: The answer is "wke", with the length of 3.
 * ` Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ` Example 4:
 * <p>
 * ` Input: s = ""
 * ` Output: 0
 * <p>
 * ` @author: rtliu
 * ` @date: 2021/4/6 3:41 下午
 */
public class _3_longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    /**
     * 这个是典型的滑动窗口类的题型
     *
     * 我们遇到相同的字符就丢弃之前字符左边的所有字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length() * 2);

        int result = 0;
        int head = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && head < map.get(c)) {
                head = map.get(c);
            }
            // i+1 表示当前字符的实际位置
            result = Math.max(i + 1 - head, result);
            map.put(c, i + 1);
        }

        return result;
    }
}
