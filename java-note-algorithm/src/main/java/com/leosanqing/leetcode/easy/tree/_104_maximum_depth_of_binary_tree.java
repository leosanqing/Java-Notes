package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/28 下午4:31
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given a binary tree, find its maximum depth.
 * `          The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * `          Note: A leaf is a node with no children.
 * `      Example:  Given binary tree [3,9,20,null,null,15,7],
 * `                  3
 * `                 / \
 * `                9  20
 * `                  /  \
 * `                 15   7
 * `            return its depth = 3.
 * @Version: 1.0
 */
public class _104_maximum_depth_of_binary_tree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(7);
        System.out.println(maxDepth(treeNode));
    }

    static class Num{
        int max;
    }

    public static int maxDepth(TreeNode root) {
        Num num = new Num();
        num.max = 0;
        if (root == null) {
            return 0;
        }
        backtrace(root, 0, num);
        return num.max;
    }

    private static void backtrace(TreeNode root, int curInt, Num max) {
        if (root == null) {
            return;
        }

        max.max = Math.max(++curInt, max.max);

        backtrace(root.left, curInt, max);
        backtrace(root.right, curInt, max);
    }

}
