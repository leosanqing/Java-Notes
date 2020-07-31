package com.leosanqing.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 上午11:26
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * Given a binary tree and a sum,
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * Example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \     4   8    /   / \   11  13  4  /  \    / \ 7    2  5   1 Return:  [    [5,4,11,2],    [5,8,4,5] ]
 * @Version: 1.0
 */
public class _113_path_sumII {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.right = new TreeNode(1);
        treeNode.right.right.left = new TreeNode(5);

        pathSum(treeNode, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        backTrace(answer, new ArrayList<>(), root, sum);
        return answer;
    }

    private static void backTrace(List<List<Integer>> answer, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            answer.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        backTrace(answer, list, root.left, sum - root.val);
        backTrace(answer, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
