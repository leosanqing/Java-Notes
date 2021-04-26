package com.leosanqing.leetcode.easy;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/6/1 下午5:51
 * @Package: com.leosanqing.leetcode.easy
 * @Description: Reverse a singly linked list.
 * 反转单链表
 * @Version: 1.0
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class _206_reverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);

        ListNode listNode = reverseList(node5);

        while(listNode!=null){
            System.out.println(listNode.val);
            listNode= listNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){

            // 顺序不能反
            ListNode next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }

        return pre;
    }

}
