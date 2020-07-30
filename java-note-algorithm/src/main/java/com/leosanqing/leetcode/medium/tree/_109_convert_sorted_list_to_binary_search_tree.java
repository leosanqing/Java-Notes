package com.leosanqing.leetcode.medium.tree;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/30 上午9:56
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          Given a singly linked list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 * `      For this problem,
 * `          a height-balanced binary tree is defined as a binary tree in which
 * `          the depth of the two subtrees of every node never differ by more than 1.
 * `      Example:
 * `          Given the sorted linked list: [-10,-3,0,5,9],
 * `          One possible answer is: [0,-3,9,-10,null,5],
 * `          which represents the following height balanced BST:
 * `                      0
 * `                     / \
 * `                   -3   9
 * `                   /   /
 * `                 -10  5
 * @Version: 1.0
 */
public class _109_convert_sorted_list_to_binary_search_tree {


    public TreeNode sortedListToBST(ListNode head) {
        return backTrace(head, null);
    }

    private static TreeNode backTrace(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = backTrace(head, slow);
        root.right = backTrace(slow.next, tail);
        return root;
    }
}
