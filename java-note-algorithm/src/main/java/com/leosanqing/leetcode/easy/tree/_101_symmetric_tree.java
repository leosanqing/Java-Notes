package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 下午3:46
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * `          For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * `                      1
 * `                     / \
 * `                    2   2
 * `                   / \ / \
 * `                  3  4 4  3
 * `          But the following [1,2,2,null,3,null,3] is not:
 * `                      1
 * `                     / \
 * `                    2   2
 * `                     \   \
 * `                      3   3
 * @Version: 1.0
 */
public class _101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return backTrace(root.left,root.right);
    }


    private boolean backTrace(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return backTrace(left.left, right.right) && backTrace(left.right, right.left);
    }


}
