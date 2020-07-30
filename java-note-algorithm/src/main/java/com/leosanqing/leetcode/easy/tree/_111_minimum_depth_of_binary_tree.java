package com.leosanqing.leetcode.easy.tree;

import com.leosanqing.leetcode.medium.tree.TreeNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/30 下午3:53
 * @Package: com.leosanqing.leetcode.easy.tree
 * @Description: 1
 * `          Given a binary tree, find its minimum depth.
 * `          The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * `          Note: A leaf is a node with no children.
 * `      Example:
 * `          Given binary tree [3,9,20,null,null,15,7],
 * `                  3
 * `                 / \
 * `                9  20
 * `                  /  \
 * `                 15   7
 * `          return its minimum depth = 2.
 * @Version: 1.0
 */
public class _111_minimum_depth_of_binary_tree {


    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
