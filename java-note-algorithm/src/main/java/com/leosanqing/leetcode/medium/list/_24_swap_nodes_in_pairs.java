package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/9 上午10:25
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: `         Given a linked list, swap every two adjacent nodes and return its head.
 * `         You may not modify the values in the list's nodes, only nodes itself may be changed.
 * `     Example:
 * `         Given 1->2->3->4,
 * `         you should return the list as 2->1->4->3.
 * @Version: 1.0
 */
public class _24_swap_nodes_in_pairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(6, node2);
        ListNode node4 = new ListNode(1, node3);

        ListNode x = swapPairs(node4);

        while (x != null) {
            System.out.println(x.val);
            x= x.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        ListNode root = fakeHead;
        ListNode pre = head;
        ListNode curr = pre.next;

        while (pre.next != null) {
            root.next = pre.next;
            pre.next = curr.next;
            curr.next = pre;

            root = curr.next;
            if (pre.next == null) {
                return fakeHead.next;
            }
            curr = pre.next.next;
            pre = root.next;
        }
        return fakeHead.next;
    }

}
