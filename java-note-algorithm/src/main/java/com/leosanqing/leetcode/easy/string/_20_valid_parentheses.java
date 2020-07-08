package com.leosanqing.leetcode.easy.string;

import java.util.Stack;

/**
 * @Author: rtliu
 * @Date: 2020/7/7 下午4:20
 * @Package: com.leosanqing.leetcode.easy.string
 * @Description: `     Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * `     determine if the input string is valid.
 * `     An input string is valid if:
 * `     Open brackets must be closed by the same type of brackets.
 * `     Open brackets must be closed in the correct order.
 * `     Note that an empty string is also considered valid.
 * `  Example 1:
 * `     Input: "()"
 * `     Output: true
 * `  Example 2:
 * `     Input: "()[]{}"
 * `     Output: true
 * `  Example 3:
 * `     Input: "(]"
 * `     Output: false
 * `  Example 4:
 * `     Input: "([)]"
 * `     Output: false
 * `  Example 5:
 * `     Input: "{[]}"
 * `     Output: true
 * @Version: 1.0
 */
public class _20_valid_parentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        if (s == null || "".equals(s)) {
            return true;
        }

        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
