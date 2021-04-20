package com.leosanqing.leetcode.medium.tree;

import java.util.HashMap;
import java.util.Map;

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


//        TreeNode treeNode1 = backTrace(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        TreeNode treeNode = buildTree(preorder, inorder);


    }

    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>(preorder.length * 2);
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return backtrace(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    private static TreeNode backtrace(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preStart]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preStart]);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inStart;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = backtrace(preorder, preStart + 1, preStart + sizeLeftSubtree, inorder, inStart, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = backtrace(preorder, preStart + sizeLeftSubtree + 1, preEnd, inorder, inorderRoot + 1, inEnd);

        return root;
    }
}
