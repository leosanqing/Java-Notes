package com.leosanqing.leetcode.medium.string;

/**
 * @Author: rtliu
 * @Date: 2020/7/22 下午4:16
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * `          A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * `              'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * `          Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * `      Example 1:
 * `          Input: "12"
 * `          Output: 2
 * `          Explanation:
 * `              It could be decoded as "AB" (1 2) or "L" (12).
 * `      Example 2:
 * `          Input: "226"
 * `          Output: 3
 * `          Explanation:
 * `              It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * @Version: 1.0
 */
public class _91_decode_ways {
    public static void main(String[] args) {

        System.out.println(numDecodings("2262"));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));


            // 如果这位数是 1-9， 那么 他可以就等于之前的位数，按照单个算
            // 如 2221  我如果只看最后一位1，那么他的可能性肯定只会等于 222的可能性
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i - 1];
            }

            // 如果 我们 两位 两位看，他的可能性就是之前一位的加上 两位的可能性
            // 如 1211 最后 1 的可能性就是 121 + 12 的可能性
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }


}
