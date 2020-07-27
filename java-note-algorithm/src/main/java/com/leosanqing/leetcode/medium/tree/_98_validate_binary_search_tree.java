package com.leosanqing.leetcode.medium.tree;

import java.util.Stack;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 上午10:31
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `         Given a binary tree, determine if it is a valid binary search tree (BST).
 * `         Assume a BST is defined as follows:
 * `             The left subtree of a node contains only nodes with keys less than the node's key.
 * `             The right subtree of a node contains only nodes with keys greater than the node's key.
 * `             Both the left and right subtrees must also be binary search trees.
 * `     Example 1:
 * `                 2
 * `                / \
 * `               1   3
 * `           Input: [2,1,3]
 * `           Output: true
 * `     Example 2:      5
 * `                     / \
 * `                    1   4
 * `                       / \
 * `                     3   6
 * `           Input: [5,1,4,null,null,3,6]
 * `           Output: false
 * `           Explanation: The root node's value is 5 but its right child's value is 4.
 * @Version: 1.0
 */
public class _98_validate_binary_search_tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        return backTrace(root, null, null);

    }

    // 又是递归
    private static boolean backTrace(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }

        // 左子树一定小于父节点，右子树一定大于父节点
        if ((max != null && treeNode.val >= max)
                || (min != null && treeNode.val <= min )) {
            return false;
        }
        return backTrace(treeNode.left, min, treeNode.val) && backTrace(treeNode.right, treeNode.val, max);
    }
}
