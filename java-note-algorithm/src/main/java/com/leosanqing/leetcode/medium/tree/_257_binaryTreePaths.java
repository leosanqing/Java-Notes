package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/6/22 下午3:08
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: Given a binary tree, return all root-to-leaf paths.
 * @Version: 1.0
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class _257_binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strings = new ArrayList<>();

        if (root != null) {
            searchBT(root,"",strings);
        }


        return strings;
    }

    private void searchBT(TreeNode node, String path, List<String> list) {
        if (node.left == null && node.right == null) {
            list.add(path + node.val);

        }
        if (node.right != null) {
            searchBT(node.right, path + node.val + "->", list);
        }
        if(node.left != null){
            searchBT(node.left, path + node.val + "->", list);
        }
    }

}


