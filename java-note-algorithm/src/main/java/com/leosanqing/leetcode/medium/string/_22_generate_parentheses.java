package com.leosanqing.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/8 下午3:44
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: `     Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * `
 * `     For example,
 * `         given n = 3, a solution set is:
 * `         [
 * `             "((()))",
 * `             "(()())",
 * `             "(())()",
 * `             "()(())",
 * `             "()()()"
 * `         ]
 * @Version: 1.0
 */
public class _22_generate_parentheses {


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        backtrace(list, new StringBuilder(), 0, 0, n);

        return list;
    }


    private static void backtrace(List<String> result, StringBuilder sb, int left, int right, int max) {
        if (left == max && right == max) {
            result.add(sb.toString());
            return;
        }

        if (left <= max) {
            sb.append("(");
            backtrace(result, sb, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        // 避免出现 ())这种情况
        if (right < left) {
            sb.append(")");
            backtrace(result, sb, left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
