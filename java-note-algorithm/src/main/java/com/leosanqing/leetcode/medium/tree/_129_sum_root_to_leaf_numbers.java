package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/8/3 上午11:26
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a binary tree containing digits from 0-9 only,
 * `          each root-to-leaf path could represent a number.
 * `          An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * `          Find the total sum of all root-to-leaf numbers.
 * `      Note: A leaf is a node with no children.
 * `      Example:
 * `          Input: [1,2,3]
 * `                  1
 * `                 / \
 * `                2   3
 * `          Output: 25
 * `          Explanation:
 * `              The root-to-leaf path 1->2 represents the number 12.
 * `              The root-to-leaf path 1->3 represents the number 13.
 * `              Therefore, sum = 12 + 13 = 25.
 * `      Example 2:
 * `          Input: [4,9,0,5,1]
 * `                  4
 * `                 / \
 * `                9   0
 * `               / \
 * `              5   1
 * `          Output: 1026
 * `          Explanation:
 * `              The root-to-leaf path 4->9->5 represents the number 495.
 * `              The root-to-leaf path 4->9->1 represents the number 491.
 * `              The root-to-leaf path 4->0 represents the number 40. Therefore, sum = 495 + 491 + 40 = 1026.
 * @Version: 1.0
 */
public class _129_sum_root_to_leaf_numbers {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        sumNumbers(treeNode);
    }

    public static int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        backTrace(root, 0, list);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }


    private static void backTrace(TreeNode root, int val, List<Integer> list) {
        if(root == null){
            return;
        }
        val = val * 10 +root.val;

        if(root.left == null && root.right == null){

            list.add(val);
            return;
        }
        backTrace(root.left, val, list);
        backTrace(root.right, val, list);
    }
}
