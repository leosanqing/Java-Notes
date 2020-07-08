package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/7 下午3:47
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: Given a linked list, remove the n-th node from the end of list and return its head.
 *
 *
 *` `Example:
 *` `     Give linked list: 1->2->3->4->5, and n = 2.
 *` `     After removing the second node from the end, the linked list becomes
 *` `     1->2->3->5.
 *` `     Note:  Given n will always be valid.
 * @Version: 1.0
 */
public class _19_remove_Nth_node_from_end_of_list {

    public static void main(String[] args) {

    }

    /**
     * 思路就是使用两个节点，一个快节点先走 n步，然后快节点走到最后，后面的那个节点就是我们要去掉的节点
     * 设置一个虚拟头结点，可以帮助我们解决边界值问题
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 设置一个虚拟的头结点，便于后面做边界值判断
        ListNode  fakeHead = new ListNode();
        fakeHead.next = head;

        // 快节点，用于记录n
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        ListNode pre = fakeHead;
        ListNode curr = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            pre = curr;
            curr = curr.next;
        }


        pre.next = curr.next;


        return fakeHead.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
