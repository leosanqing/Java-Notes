package com.leosanqing.leetcode.medium.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午7:44
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * `          给定两个整数n和k，返回1 ... n中k个数字的所有可能组合。
 * `          Example:
 * `              Input: n = 4, k = 2
 * `              Output: [   [2,4],   [3,4],   [2,3],   [1,2],   [1,3],   [1,4], ]
 * @Version: 1.0
 */
public class _77_combinations {
    public static void main(String[] args) {

        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {

        if (n == 0 || k <= 0) {

            return new ArrayList<>();
        }
        List<List<Integer>> answer = new ArrayList<>();

        backTrace(answer, new ArrayList<>(), k, n, 1);

        return answer;
    }


    public static void backTrace(List<List<Integer>> answer, List<Integer> list, int k, int n, int position) {

        if (list.size() == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = position; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            backTrace(answer, list, k, n, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
