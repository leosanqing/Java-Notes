package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/30 上午9:26
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * `       For this problem,
 * `          a height-balanced binary tree is defined as a binary tree in
 * `          which the depth of the two subtrees of every node never differ by more than 1.
 * `
 * `
 * `          给定一个数组，其中元素按升序排序，请将其转换为高度平衡的BST。
 * `          比如这个问题，
 * `          高度平衡的二叉树被定义为
 * `          每个节点的两个子树的深度相差不超过1。
 * `      Example:
 * `          Given the sorted array: [-10,-3,0,5,9],
 * `          One possible answer is: [0,-3,9,-10,null,5],
 * `          which represents the following height balanced BST:
 * `                      0
 * `                     / \
 * `                   -3   9
 * `                   /   /
 * `                 -10  5
 * @Version: 1.0
 */
public class _108_convert_sorted_array_to_binary_search_tree {

    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(111);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return backTrace(nums, 0, nums.length - 1);

    }

    private static TreeNode backTrace(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (right - left) / 2 + left;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = backTrace(nums, left, mid - 1);
        root.right = backTrace(nums, mid + 1, right);
        return root;
    }


}
