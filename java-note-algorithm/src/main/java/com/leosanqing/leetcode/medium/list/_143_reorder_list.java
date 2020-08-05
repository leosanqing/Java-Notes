package com.leosanqing.leetcode.medium.list;

import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 下午5:03
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * `          reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * `          You may not modify the values in the list's nodes, only nodes itself may be changed.
 * `          给定一个单链表L：L0→L1→…→Ln-1→Ln，
 * `          将其重新排序为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * `          您不能修改列表节点中的值，只能更改节点本身。
 * `      Example 1:
 * `          Given 1->2->3->4,
 * `          reorder it to 1->4->2->3.
 * `      Example 2:
 * `          Given 1->2->3->4->5,
 * `           reorder it to 1->5->2->4->3.
 * @Version: 1.0
 */
public class _143_reorder_list {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(6);

        reorderList(listNode);
    }

    /**
     * 分三步完成
     * 1. 找到中点
     * 2. 反转中点后的节点
     * 3. 然后挨个进行重组
     *
     * @param head
     */
    public static void reorderList(ListNode head) {

        if (head == null) {
            return;
        }
        // 1。找到中点
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;
        ListNode fast = fakeNode;
        ListNode slow = fakeNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        // 2. 反转中点之后的节点 1 -> 2 -> 3 -> 4 -> 5 -> 6 变成 1 -> 2 -> 3 -> 6 -> 5 -> 4
        ListNode slowNext = reverse(slow.next);

        // 3. 重组 1 -> 2 -> 3 -> 6 -> 5 -> 4  变成 1 -> 6 -> 2 -> 5 -> 3 -> 4

        slow = head;
        ListNode firstNext;
        fast = slowNext;
        ListNode secondNext;
        while (slow.next != null && fast != null) {
            secondNext = fast.next;
            firstNext = slow.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = secondNext;
            slow = firstNext;
        }

        slow.next = null;
        System.out.println();

    }

    private static ListNode reverse(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = reverse(node.next);

        node.next.next = node;
        node.next = null;
        return next;
    }

}
