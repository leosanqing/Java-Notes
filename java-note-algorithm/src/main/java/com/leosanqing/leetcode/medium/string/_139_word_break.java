package com.leosanqing.leetcode.medium.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 上午11:38
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * 1          Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * 1          determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 1          给定一个非空字符串s和一个包含非空单词列表的字典wordDict，
 * 1          确定是否可以将s分割为一个或多个词典单词的以空格分隔的序列
 * 1
 * 1       Note:
 * 1          The same word in the dictionary may be reused multiple times in the segmentation.
 * 1          You may assume the dictionary does not contain duplicate words.
 * 1       Example 1:
 * 1          Input: s = "leetcode", wordDict = ["leet", "code"]
 * 1          Output: true
 * 1          Explanation:
 * 1              Return true because "leetcode" can be segmented as "leet code".
 * 1       Example 2:
 * 1          Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * 1          Output: true
 * 1          Explanation:
 * 1              Return true because "applepenapple" can be segmented as "apple pen apple".
 * 1          Note that you are allowed to reuse a dictionary word.
 * 1       Example 3:
 * 1          Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 1          Output: false
 * 1
 * @Version: 1.0
 */
public class _139_word_break {

    static Set<String> set;

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(wordBreak(s, Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return backtrace(s, 0, new HashSet<>());

    }


    private static boolean backtrace(String s, int position, Set<Integer> words) {
        if (position == s.length()) {
            return true;
        }

        // 如果存在，则说明已经尝试过这种方法，就直接返回
        if (words.contains(position)) {
            return false;
        }

        for (int i = position + 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(position, i))) {
                continue;
            }

            if (backtrace(s, i, words)) {
                return true;
            }

            words.add(i);
        }

        words.add(position);
        return false;
    }
}
