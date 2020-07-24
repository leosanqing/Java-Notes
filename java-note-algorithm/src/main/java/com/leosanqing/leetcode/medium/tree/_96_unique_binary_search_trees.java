package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/24 上午10:29
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `         Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ..
 * . n.
 * `      Example:
 * `          Input: 3
 * `          Output: 5
 * `
 * `          Explanation:
 * `              The above output corresponds to the 5 unique BST's shown below:
 * `                                  1          3        3         2       1
 * `                                   \        /        /         / \       \
 * `                                    3      2        1         1   3       2
 * `                                   /     /           \                     \
 * `                                 2     1              2                     3
 * @Version: 1.0
 */
public class _96_unique_binary_search_trees {

    public static void main(String[] args) {
        generateTrees(8);
    }


    /**
     * 解释  ：https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
     * @param n
     * @return
     */
    public static int generateTrees(int n) {
        int[] res = new int[n+1];

        res[0] = res[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] += res[j-1] * res[i-j];
            }
        }

        return res[n];
    }



}
