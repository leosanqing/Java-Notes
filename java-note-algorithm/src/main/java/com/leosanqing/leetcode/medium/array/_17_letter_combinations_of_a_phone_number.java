package com.leosanqing.leetcode.medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/6 上午11:22
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: ` `     Given a string containing digits from 2-9 inclusive,
 * ` `     return all possible letter combinations that the number could represent.
 * ` `     A mapping of digit to letters (just like on the telephone buttons) is given below.
 * ` `     Note that 1 does not map to any letters.
 * ` `  Example:
 * ` `     Input: '23'
 * ` `     Output: ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf'].
 * @Version: 1.0
 */
public class _17_letter_combinations_of_a_phone_number {

    public static void main(String[] args) {

        System.out.println(letterCombinations("5465768"));
    }

    public static List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();

        List<String> list = new LinkedList<>();
        char[][] map = {
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };

        backtrack(charArray, list, map, new StringBuilder(), 0);
        return list;

    }


    private static void backtrack(char[] digits, List<String> list, char[][] map, StringBuilder sb, int offset) {
        if (offset == digits.length) {
            list.add(sb.toString());
            return;
        }

        // 获得 map 的索引
        int index = digits[offset] - '0';
        // 遍历每个按键的所有情况
        for (int i = 0; i < map[index].length; i++) {
            // 挨个追加值
            sb.append(map[index][i]);
            backtrack(digits, list, map, sb, offset + 1);
            // 删除
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
