package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/21 下午5:28
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 *`          Given a sorted linked list, delete all duplicates such that each element appear only once.
 *`      Example 1:
 *`          Input: 1->1->2
 *`          Output: 1->2
 *`      Example 2:
 *`          Input: 1->1->2->3->3
 *`          Output: 1->2->3
 * @Version: 1.0
 */
public class _83_remove_duplicates_from_sorted_list {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(1,node3);
        ListNode node5 = new ListNode(1, node4);
        ListNode node6 = new ListNode(1, node5);
        ListNode node7 = new ListNode(1, node6);

        System.out.println(deleteDuplicates(node7).val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeNode = new ListNode(Integer.MIN_VALUE);
        fakeNode.next = head;

        ListNode pre = fakeNode;
        ListNode cur = pre.next;


        while (cur != null){
            if(pre.val == cur.val){
                cur = cur.next;
                pre.next = cur;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }

        return fakeNode.next;
    }
}
