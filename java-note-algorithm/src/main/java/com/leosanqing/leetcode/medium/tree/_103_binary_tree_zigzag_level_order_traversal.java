package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 下午5:29
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * `          (ie, from left to right, then right to left for the next level and alternate between).
 * `          给定一棵二叉树，返回其节点值的之字形级别顺序遍历。
 * `          （即，从左到右，然后从右到左进入下一个级别，并在之间切换）。
 * `      For example:
 * `          Given binary tree [3,9,20,null,null,15,7],
 * `                  3
 * `                 / \
 * `                9  20
 * `                  /  \
 * `                 15   7
 * `          return its zigzag level order traversal as:
 * `              [
 * `                  [3],
 * `                  [20,9],
 * `                  [15,7]
 * `              ]
 * @Version: 1.0
 */
public class _103_binary_tree_zigzag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> answer = new ArrayList<>();
        answer.add(Arrays.asList(root));

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        findAnswer(answer, new ArrayList<>(), res, new ArrayList<>());
        return res;
    }

    /**
     * 这个就简单的改造一下 102的解法，加一个条件判断
     * @param lists
     * @param list
     * @param answer
     * @param temp
     */
    private static void findAnswer(List<List<TreeNode>> lists, List<TreeNode> list, List<List<Integer>> answer,
                                   List<Integer> temp) {
        boolean flag = true;
        while (true) {
            List<TreeNode> treeNodes = lists.get(lists.size() - 1);
            for (int i = treeNodes.size() - 1; i >= 0; i--) {
                if (flag) {
                    if (treeNodes.get(i).right != null) {
                        list.add(treeNodes.get(i).right);
                        temp.add(treeNodes.get(i).right.val);
                    }
                    if (treeNodes.get(i).left != null) {
                        list.add(treeNodes.get(i).left);
                        temp.add(treeNodes.get(i).left.val);
                    }
                } else {
                    if (treeNodes.get(i).left != null) {
                        list.add(treeNodes.get(i).left);
                        temp.add(treeNodes.get(i).left.val);
                    }

                    if (treeNodes.get(i).right != null) {
                        list.add(treeNodes.get(i).right);
                        temp.add(treeNodes.get(i).right.val);
                    }
                }

            }


            if (list.isEmpty()) {
                return;
            }
            lists.add(new ArrayList<>(list));
            answer.add(new ArrayList<>(temp));
            list.clear();
            temp.clear();

            flag = !flag;
        }
    }
}
