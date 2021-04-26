package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/6/1 下午7:01
 * @Package: com.leosanqing.leetcode.medium
 * @Description: Reverse a linked list from position m to n. Do it in one-pass.
 * 对反转给定范围的链表节点进行反转，只遍历一遍
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * @Version: 1.0
 */
public class _92_reverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        // 设置一个虚拟头结点
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur1 = fakeHead;
        ListNode pre1 = null;

        // 找到 m 的位置
        for (int i = 0; i < m; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        ListNode next;
        ListNode pre2 = pre1;
        ListNode cur2 = cur1;
        for (int i = 0; i <= n - m; i++) {
            next = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next;
        }

        // 反转完之后，链接 m 之前的节点 和 n 后的节点
        pre1.next = pre2;
        cur1.next = cur2;

        return fakeHead.next;
    }


}
