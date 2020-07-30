package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/29 下午4:15
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * `          (ie, from left to right, level by level from leaf to root).
 * `      For example: Given binary tree [3,9,20,null,null,15,7],
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * `          return its bottom-up level order traversal as:
 * `              [
 * `                  [15,7],
 * `                  [9,20],
 * `                  [3]
 * `              ]
 * @Version: 1.0
 */
public class _107_binary_tree_level_order_traversalII {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        levelOrderBottom(treeNode);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();

        backTrace(answer, 0, root);
        Collections.reverse(answer);
        return answer;
    }


    private static void backTrace(List<List<Integer>> answer, int depth, TreeNode root) {
        if (root == null) {
            return;
        }

        if (answer.size() > depth) {
            answer.get(depth).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            answer.add(new ArrayList<>(list));
        }

        backTrace(answer, depth + 1, root.left);
        backTrace(answer, depth + 1, root.right);

    }
}
