package com.leosanqing.leetcode.medium.array;

import java.util.*;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 下午2:18
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 * ` `         Given an array of strings, group anagrams together.
 * ` `         给定一个字符串数组，将字谜分组在一起。
 * ` `     Example:
 * ` `         Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * ` `         Output:
 * ` `             [
 * ` `                 ["ate","eat","tea"],
 * ` `                 ["nat","tan"],
 * ` `                 ["bat"]
 * ` `             ]
 * @Version: 1.0
 */
public class _49_group_anagrams {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return answer;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String s = Arrays.toString(chars);

            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s,list);

        }
        return new ArrayList<>(map.values());


    }
}
