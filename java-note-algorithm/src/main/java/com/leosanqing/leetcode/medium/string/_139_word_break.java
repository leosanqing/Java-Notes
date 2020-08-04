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

    public static void main(String[] args) {
        String s = "leetcode";

        wordBreak(s, Arrays.asList("leet", "code"));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, new HashSet<>(wordDict), new HashSet<>());

    }


    private static boolean backTrace(String s, int position, Set<String> wordSet, Set<Integer> set) {
        // 如果到最后了  肯定完全匹配了，
        // 因为这个position 是坐标，比如 上面的leetcode ，position 为 8，那么他已经完全匹配完了的，因为position为7时就已经匹配完了
        if (position == s.length()) {
            return true;
        }

        // 如果有这个坐标，那么就说明后面的试过了无效，可以直接返回
        if (set.contains(position)) {
            return false;
        }

        for (int i = position + 1; i <= s.length(); i++) {
            String substring = s.substring(position, i);
            if (!wordSet.contains(substring)) {
                continue;
            }

            if (backTrace(s, i, wordSet, set)){
                return true;
            }else {
                set.add(i);
            }

        }

        set.add(position);

        return false;

    }


    private static boolean dfs(String s, int index, Set<String> dict, Set<Integer> set) {
        // base case
        if (index == s.length()) {
            return true;
        }
        // check memory
        if (set.contains(index)) {
            return false;
        }
        // recursion
        for (int i = index + 1; i <= s.length(); i++) {
            String t = s.substring(index, i);
            if (!dict.contains(t)) {
                continue;
            }
            if (dfs(s, i, dict, set)) {
                return true;
            } else {
                set.add(i);
            }
        }


        set.add(index);
        return false;
    }
}
