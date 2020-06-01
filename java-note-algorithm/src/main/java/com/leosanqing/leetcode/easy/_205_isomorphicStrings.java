package com.leosanqing.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: rtliu
 * @Date: 2020/6/1 下午4:14
 * @Package: com.leosanqing.leetcode.easy
 * @Description: Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * 给定两个字符串s和t，确定它们是否同构。
 * 如果可以替换s中的字符以获得t，则两个字符串是同构的。
 * 在保留字符顺序的同时，必须将所有出现的字符替换为另一个字符。
 * 不能将两个字符映射到同一字符，但是可以将一个字符映射到自身。
 * @Version: 1.0
 * <p>
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class _205_isomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aba","baa"));
        System.out.println(isIsomorphic("paper","tifae"));
        System.out.println(isIsomorphic("egg","foo"));
        System.out.println(isIsomorphic("paper","title"));

    }



    public static boolean isIsomorphic(String s, String t) {

        Map<Character,Integer> sHashMap = new HashMap<>(256);
        Map<Character,Integer> tHashMap = new HashMap<>(256);

        if(s.length() != t.length()){
            return false;
        }

        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {


            sChar = s.charAt(i);
            tChar = t.charAt(i);
            // 如果sMap 中有，但是tMap中 没有，那么肯定就是有问题的
            // 或者 如果tMap 中有，但是sMap中 没有
            if((!sHashMap.containsKey(sChar) && tHashMap.containsKey(tChar))
                    || (sHashMap.containsKey(sChar) && !tHashMap.containsKey(tChar))){
                return false;
            }
            if(!sHashMap.containsKey(sChar)){
                sHashMap.put(sChar,i);
            }

            if(!tHashMap.containsKey(tChar)){
                tHashMap.put(tChar,i);
            }

            if(!sHashMap.get(sChar).equals(tHashMap.get(tChar))){
                return false;
            }
        }

        return true;
    }


    /**
     * 大佬们的算法，据说时间 3ms，
     * 这边是使用 数组，
     * @param sString
     * @param tString
     * @return
     */
    public boolean isIsomorphic2(String sString, String tString) {

        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) {
            return false;
        }

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            // 如果
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }

}
