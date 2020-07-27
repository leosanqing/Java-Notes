package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/24 上午10:29
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ..
 * . n.
 * `      Example:
 * `          Input: 3
 * `          Output:
 * `              [
 * `                  [1,null,3,2],
 * `                  [3,2,null,1],
 * `                  [3,1,null,null,2],
 * `                  [2,1,3],
 * `                  [1,null,2,null,3]
 * `              ]
 * `          Explanation:
 * `              The above output corresponds to the 5 unique BST's shown below:
 * `                                  1          3        3         2       1
 * `                                   \        /        /         / \       \
 * `                                    3      2        1         1   3       2
 * `                                   /     /           \                     \
 * `                                 2     1              2                     3
 * @Version: 1.0
 */
public class _95_unique_binary_search_treesII {

    public static void main(String[] args) {
        generateTrees(8);
    }

    public static List<TreeNode> generateTrees(int n) {

        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<>();
        if (n == 0) {
            return res[0];
        }
        res[0].add(null);
        res[1] = new ArrayList<>();
        res[1].add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            res[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode nodeL : res[j - 1]) {
                    for (TreeNode nodeR : res[i - j]) {
                        TreeNode node = new TreeNode(j);
                        node.left = nodeL;
                        node.right = clone(nodeR, j);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }


    static TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);
        return newNode;
    }


    private void backTrace(List<TreeNode> result, TreeNode cur, TreeNode root, int position, int max) {
        if (position == max) {
            result.add(root);
        }


    }

}
