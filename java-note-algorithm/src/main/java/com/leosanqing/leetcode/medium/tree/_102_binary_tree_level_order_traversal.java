package com.leosanqing.leetcode.medium.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 下午4:07
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a binary tree, return the level order traversal of its nodes' values.
 * `          (ie, from left to right, level by level).
 * `          For example: Given binary tree [3,9,20,null,null,15,7],
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * `         return its level order traversal as:
 * `              [
 * `                  [3],
 * `                  [9,20],
 * `                  [15,7]
 * `              ]
 * @Version: 1.0
 */
public class _102_binary_tree_level_order_traversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(7);

        System.out.println(JSON.toJSONString(levelOrder(treeNode)));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrace(answer, 0, root);
        return answer;
    }

    private static void backtrace(List<List<Integer>> answer, int depth, TreeNode node) {
        if (node == null) {
            return;
        }

        if (depth >= answer.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            answer.add(list);
        } else {
            answer.get(depth).add(node.val);
        }

        backtrace(answer, depth + 1, node.left);
        backtrace(answer, depth + 1, node.right);
    }
}
