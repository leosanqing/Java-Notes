package com.leosanqing.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/23 下午4:47
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * `          Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * `          A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by
 * single points.
 * `      Example:
 * `          Input: "25525511135"
 * `          Output: ["255.255.11.135", "255.255.111.35"]
 * @Version: 1.0
 */
public class _93_restore_IP_addresses {

    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);

        System.out.println(s.substring(0,1));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    public static List<String> restoreIpAddresses1(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d == s.length()) {
                            int num1 = Integer.parseInt(s.substring(0, a));
                            int num2 = Integer.parseInt(s.substring(a, a + b));
                            int num3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int num4 = Integer.parseInt(s.substring(a + b + c));

                            if (num1 <= 255 && num2 <= 255 && num3 <= 255 && num4 <= 255) {
                                result.add(num1 + "." + num2 + "." + num3 + "." + num4);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    /**
     *
     * @param result
     * @param path 已经组成的ip地址
     * @param s 去掉path 后的 剩余的字符  如初始为 2222，path 为 2.2  str 为22
     * @param k 已经有几段ip地址了  如 运行到 k=2 ,这个时候 path 为 22.22
     */
    private static void doRestore(List<String> result, String path, String s, int k) {
        if (k == 4 || s.isEmpty()) {
            if (k == 4 && s.isEmpty()) {
                result.add(path.substring(1));
            }
            return;
        }

        // 如果 s开头为0，只能截取1个字符，不然会出现 22.02  不符合规则
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            //
            String part = s.substring(0, i);
            // 必须小于 255
            if (Integer.parseInt(part) <= 255) {
                doRestore(result, path + "." + part, s.substring(i), k + 1);
            }
        }
    }
}
