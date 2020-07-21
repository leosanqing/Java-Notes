package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/21 下午4:48
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 * `          Given a sorted linked list, delete all nodes that have duplicate numbers,
 * `          leaving only distinct numbers from the original list.
 * `          Return the linked list sorted as well.
 * `      Example 1:
 * `          Input: 1->2->3->3->4->4->5
 * `          Output: 1->2->5
 * `      Example 2:
 * `          Input: 1->1->1->2->3
 * `          Output: 2->3
 * @Version: 1.0
 */
public class _82_remove_duplicates_from_sorted_listII {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode node5 = new ListNode(2, node4);
        ListNode node6 = new ListNode(2, node5);
        ListNode node7 = new ListNode(1, node6);

        deleteDuplicates(node7);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;

        ListNode pre = fakeNode;
        ListNode cur = fakeNode.next;
        ListNode next = cur.next;
        while (next != null) {
            if(next.val != cur.val){
                pre = cur;
                cur = next;
                next = cur.next;
                continue;
            }
            // 一直找到不重复的
            while(next != null && cur.val == next.val){
                cur = next;
                next = next.next;
            }
            // 然后把 之前的 pre 节点直接链接到 next节点。这样中间重复的就相当于被删除了
            if (next != null){
                pre.next = next;
                cur = next;
                next = cur.next;
            }else{
                pre.next = next;
            }


        }

        return fakeNode.next;
    }
}
