package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: rtliu
 * @Date: 2020/7/24 上午9:49
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given a binary tree, return the inorder traversal of its nodes' values.
 * `          给定一个二叉树，返回其节点值的有序遍历。
 * `      Example:
 * `          Input:
 * `              [1,null,2,3]
 * `                  1
 * `                   \
 * `                   2
 * `                 /
 * `               3
 * `         Output: [1,3,2]
 * @Version: 1.0
 */
public class _94_binary_tree_inorder_traversal {

    // 不使用递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;

    }


    // 使用递归
    private void backTrace(List<Integer> list, TreeNode node){

        if(node == null){
            return;
        }
        backTrace(list, node.left);
        list.add(node.val);
        backTrace(list, node.right);

    }

}
