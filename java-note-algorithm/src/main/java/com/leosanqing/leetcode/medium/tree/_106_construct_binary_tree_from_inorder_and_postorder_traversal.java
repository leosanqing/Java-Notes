package com.leosanqing.leetcode.medium.tree;

/**
 * @Author: rtliu
 * @Date: 2020/7/29 上午10:43
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `      Given inorder and postorder traversal of a tree, construct the binary tree.
 * `      Note: You may assume that duplicates do not exist in the tree.
 * `      For example,
 * `          given  inorder = [9,3,15,20,7] postorder = [9,15,7,20,3]
 * `          Return the following binary tree:
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * @Version: 1.0
 */
public class _106_construct_binary_tree_from_inorder_and_postorder_traversal {

    public static void main(String[] args) {


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return backTrace(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    /**
     * 这个跟 之前 105题解法思路一样，只不过顺序不一样
     *
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param postorder
     * @param postEnd
     * @return
     */
    private static TreeNode backTrace(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd) {

        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inIndex = 0;
        for (int i = inEnd; i >= inStart; i--) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }

        root.right = backTrace(inorder, inIndex + 1, inEnd, postorder, postEnd - 1);
        root.left = backTrace(inorder, inStart, inIndex - 1, postorder, postEnd + inIndex - inEnd - 1);
        return root;
    }
}
