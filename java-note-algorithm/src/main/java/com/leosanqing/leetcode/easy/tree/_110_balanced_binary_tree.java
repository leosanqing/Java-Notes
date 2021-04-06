package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/30 下午3:06
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given a binary tree, determine if it is height-balanced.
 * `          For this problem, a height-balanced binary tree is defined as:
 * `          a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * `      Example 1:
 * `          Given the following tree [3,9,20,null,null,15,7]:
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * `          Return true.
 * `      Example 2:
 * `          Given the following tree [1,2,2,3,3,null,null,4,4]:
 * `                      1
 * `                     / \
 * `                    2   2
 * `                   / \
 * `                  3   3
 * `                 / \
 * `                4   4
 * @Version: 1.0
 */
public class                               _110_balanced_binary_tree {

    private static boolean result = true;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(4);
        treeNode.left.right.left = new TreeNode(4);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.right.left.left = new TreeNode(4);
        treeNode.right.left.right = new TreeNode(4);
        treeNode.left.left.left.left = new TreeNode(4);
        treeNode.left.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(treeNode));
    }

    public static boolean isBalanced(TreeNode root) {
        result = true;
        backTrace(root);
        return result;
    }

    private static int backTrace(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = backTrace(root.left);
        int right = backTrace(root.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return 1 + Math.max(left, right);
    }
}
