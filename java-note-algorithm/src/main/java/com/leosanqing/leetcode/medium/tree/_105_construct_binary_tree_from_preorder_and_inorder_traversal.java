package com.leosanqing.leetcode.medium.tree;

/**
 * @Author: rtliu
 * @Date: 2020/7/28 下午7:29
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given preorder and inorder traversal of a tree, construct the binary tree.
 * `          Note: You may assume that duplicates do not exist in the tree.
 * `          For example, given  preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
 * `          Return the following binary tree:
 * `
 * `          给定一棵树的前序和有序遍历，构造二叉树。
 * `          注意：您可以假定树中不存在重复项。
 * `          例如，给定的先序遍历 = [3,9,20,15,7] 中序遍历 = [9,3,15,20,7]
 * `                      3
 * `                     / \
 * `                    9  20
 * `                      /  \
 * `                     15   7
 * @Version: 1.0
 */
public class _105_construct_binary_tree_from_preorder_and_inorder_traversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 2, 11, 14, 8, 20, 15, 16, 7, 22};
        int[] inorder = {11, 2, 14, 9, 8, 3, 16, 15, 20, 22, 7};


        TreeNode treeNode1 = backTrace(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        TreeNode treeNode = buildTree(preorder, inorder);


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return backTrace(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode backTrace(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        // 找到 inOrder 中 的索引
        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }

        root.left = backTrace(preorder, preStart + 1, preEnd, inorder, inStart, inIndex - 1);
        root.right = backTrace(preorder, preStart + inIndex - inStart + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }
}
