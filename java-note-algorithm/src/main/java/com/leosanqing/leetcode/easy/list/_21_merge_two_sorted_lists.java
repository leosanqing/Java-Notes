package com.leosanqing.leetcode.easy.list;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/7 下午4:46
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * @Version: 1.0
 */
public class _21_merge_two_sorted_lists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        System.out.println(mergeTwoLists(node3, node6));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 先处理极限情况
        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 放一个虚拟的头，用来预防各种极限值，很多解法都会使用这种方式
        ListNode newList = new ListNode();
        ListNode fakeHead = newList;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                newList.next = p1;
                p1 = p1.next;
            } else {
                newList.next = p2;
                p2 = p2.next;
            }
            newList = newList.next;
        }

        // 如果还有剩的
        if (p1 != null) {
            newList.next = p1;
        }

        if (p2 != null) {
            newList.next = p2;
        }

        return fakeHead.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode cur = new ListNode();
        ListNode fakeHead = cur;
        ListNode n1 = l1;
        ListNode n2 = l2;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        // 如果还有剩的
        if (n1 != null) {
            cur.next = n1;
        }

        if (n2 != null) {
            cur.next = n2;
        }

        return fakeHead.next;
    }
}
