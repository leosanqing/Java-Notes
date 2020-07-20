package com.leosanqing.leetcode.easy.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/15 下午5:39
 * @Package: com.leosanqing.leetcode.easy.string
 * @Description: 1
 * `          The set [1,2,3,...,n] contains a total of n! unique permutations.
 * `          By listing and labeling all of the permutations in order,
 * `          we get the following sequence for n = 3:
 * `          "123" "132" "213" "231" "312" "321" Given n and k,
 * `          return the kth permutation sequence.
 * `          集[1,2,3，...，n]总共包含n！独特的排列。
 * `          通过按顺序列出和标记所有排列，
 * `          我们得到n = 3的以下序列：
 * `          “ 123”“ 132”“ 213”“ 231”“ 312”“ 321”给定n和k，
 * `          返回第k个排列序列。
 * `          Note:
 * `              Given n will be between 1 and 9 inclusive.
 * `              Given k will be between 1 and n! inclusive.
 * `      Example 1:
 * `          Input: n = 3, k = 3
 * `          Output: "213"
 * `      Example 2:
 * `          Input: n = 4, k = 9
 * `          Output: "2314"
 * @Version: 1.0
 */
public class _60_permutation_sequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(8,30654));
    }
    public static String getPermutation(int n, int k) {

        LinkedList<Integer> notUsed = new LinkedList<>();

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            if(i == n){
                break;
            }
            sum *= i;
        }

        StringBuilder result = new StringBuilder();
        k--;

        while (true) {
            result.append(notUsed.remove(k / sum));
            k = k % sum;
            if(notUsed.isEmpty()){
                break;
            }
            sum /= notUsed.size();
        }
        return result.toString();

    }
}
