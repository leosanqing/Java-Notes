package com.leosanqing.leetcode.medium.string;

/**
 * @Author: rtliu
 * @Date: 2020/7/13 下午5:05
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * `         Given two non-negative integers num1 and num2 represented as strings,
 * `         return the product of num1 and num2, also represented as a string.
 * `
 * `         给定两个表示为字符串的非负整数num1和num2，
 * `         返回num1和num2的乘积，也表示为字符串。
 * `     Example 1:
 * `         Input: num1 = "2", num2 = "3"
 * `         Output: "6"
 * `     Example 2:
 * `         Input: num1 = "123", num2 = "456"
 * `         Output: "56088"
 * @Version: 1.0
 */
public class _43_multiply_strings {
    public static void main(String[] args) {

        System.out.println(multiply("999", "999").equals(String.valueOf(999 * 999)));

    }

    /**
     * 我们做乘法也是这样做
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;

                int sum = temp + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;

            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : result) {
            if (stringBuilder.length() == 0 && i == 0) {
                continue;
            }
            stringBuilder.append(i);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
