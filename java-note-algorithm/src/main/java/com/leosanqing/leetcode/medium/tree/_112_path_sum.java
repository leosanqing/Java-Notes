package com.leosanqing.leetcode.medium.tree;

/**
 * @Author: rtliu
 * @Date: 2020/7/30 下午5:24
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @Version: 1.0
 */
public class _112_path_sum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(treeNode, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {


        return backTrace(root, sum);
    }

    private static boolean backTrace(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val  == sum) {
            return true;
        }

        return backTrace(root.left, sum-root.val) || backTrace(root.right, sum-root.val);

    }
}
