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


        StringBuilder sb = new StringBuilder();

        helper(list, sb, 0, 0, n);

        return list;
    }


    private static void helper(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (open == max && close == max) {
            list.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append("(");
            helper(list, sb, open + 1, close, max);
            sb.setLength(sb.length() - 1);
        }

        // 注意这里，close < open ，这样就避免了 出现类似  ()))(( 的情况
        if (close < open ) {
            sb.append(")");
            helper(list, sb, open, close + 1, max);
            sb.setLength(sb.length() - 1);
        }
    }
}
