package com.leosanqing.leetcode.easy.tree;


import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/27 上午11:41
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given two binary trees, write a function to check if they are the same or not.
 * `          Two binary trees are considered the same if they are structurally identical and the nodes have the same
 * value.
 * `      Example 1:
 * `          Input:     1         1
 * `                    / \       / \
 * `                   2   3     2   3
 * `                 [1,2,3],   [1,2,3]
 * `          Output: true
 * `      Example 2:
 * `          Input:
 * `                    1         1
 * `                   /           \
 * `                  2             2
 * `                [1,2],     [1,null,2]
 * `         Output: false
 * `      Example 3:
 * `          Input:
 * `                   1         1
 * `                  / \       / \
 * `                 2   1     1   2
 * `               [1,2,1],   [1,1,2]
 * `          Output: false
 * @Version: 1.0
 */
public class _100_same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return backTrace(p,q);
    }

    private static boolean backTrace(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return backTrace(p.left, q.left) && backTrace(p.right, q.right);

    }


}
