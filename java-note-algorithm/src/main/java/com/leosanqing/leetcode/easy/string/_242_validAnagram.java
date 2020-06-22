package com.leosanqing.leetcode.easy.string;

/**
 * @Author: rtliu
 * @Date: 2020/6/22 下午4:48
 * @Package: com.leosanqing.leetcode.easy.string
 * @Description: Given two strings s and t , write a function to determine if t is an anagram of s.
 * @Version: 1.0
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class _242_validAnagram {

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i)-'a']--;
        }

        for (int i : alphabet) {
            if(i!=0){
                return false;
            }
        }

        return true;
    }
}
