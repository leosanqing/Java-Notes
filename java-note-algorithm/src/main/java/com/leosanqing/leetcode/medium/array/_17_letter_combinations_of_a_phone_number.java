package com.leosanqing.leetcode.medium.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
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

    static char[][] num = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(letterCombinations("5465768")));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }


        List<String> answer = new ArrayList<>();

        backtrace(answer, 0, new StringBuilder(), digits);

        return answer;
    }

    private static void backtrace(List<String> answer, int position, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            answer.add(new String(sb));
            return;
        }

        for (int j = 0; j < num[digits.charAt(position) - '0'].length; j++) {
            sb.append(num[digits.charAt(position) - '0'][j]);
            backtrace(answer, position + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
