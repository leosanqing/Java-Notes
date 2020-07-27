package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
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
        levelOrder(treeNode);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> answer = new ArrayList<>();
        answer.add(Arrays.asList(root));

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        findAnswer(answer, new ArrayList<>(),res,new ArrayList<>());
        return res;

    }

    private static void findAnswer(List<List<TreeNode>> lists, List<TreeNode> list,List<List<Integer>> answer, List<Integer> temp) {
        while (true) {
            for (TreeNode treeNode : lists.get(lists.size() - 1)) {
                if(treeNode.left != null){
                    list.add(treeNode.left);
                    temp.add(treeNode.left.val);
                }
                if(treeNode.right != null) {
                    list.add(treeNode.right);
                    temp.add(treeNode.right.val);
                }
            }
            if (list.isEmpty()) {
                return;
            }
            lists.add(new ArrayList<>(list));
            answer.add(new ArrayList<>(temp));
            list.clear();
            temp.clear();

        }
    }
}
