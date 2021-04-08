package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/7 下午3:47
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * <p>
 * ` `Example:
 * ` `     Give linked list: 1->2->3->4->5, and n = 2.
 * ` `     After removing the second node from the end, the linked list becomes
 * ` `     1->2->3->5.
 * ` `     Note:  Given n will always be valid.
 * @Version: 1.0
 */
public class _19_remove_Nth_node_from_end_of_list {

    public static void main(String[] args) {

    }

    /**
     * 思路就是使用两个节点，一个快节点先走 n步，然后快节点走到最后，后面的那个节点就是我们要去掉的节点
     * 设置一个虚拟头结点，可以帮助我们解决边界值问题
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();

        ListNode slow = fakeHead;
        ListNode fast = fakeHead;

        fakeHead.next = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return fakeHead.next;
    }
}
