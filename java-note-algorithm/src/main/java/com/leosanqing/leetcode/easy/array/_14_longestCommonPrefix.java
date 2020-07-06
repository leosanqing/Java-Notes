package com.leosanqing.leetcode.easy.array;

/**
 * @Author: rtliu
 * @Date: 2020/7/3 下午5:08
 * @Package: com.leosanqing.leetcode.easy.array
 * @Description: Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation:
 * There is no common prefix among the input strings.
 * @Version: 1.0
 */
public class _14_longestCommonPrefix {
    //    public static void main(String[] args) {
//        BigInteger bigDecimal = BigInteger.valueOf(Math.pow(2, 478));
//        System.out.println(bigDecimal);
//    }


    public static void main(String[] args) {
        String[] strings = new String[]{"aa","a"};

        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null ||strs.length == 0){
            return "";
        }

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 每次减去一个字符，找最长的公共前缀
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length()-1);
            }
        }

        return pre;
    }


}
