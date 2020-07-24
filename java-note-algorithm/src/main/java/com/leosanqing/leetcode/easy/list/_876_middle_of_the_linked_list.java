package com.leosanqing.leetcode.easy.list;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/7/22 上午9:28
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: 1
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5]) The returned node has value 3.
 * (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that: ans.val = 3,
 * ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * @Version: 1.0
 */
public class _876_middle_of_the_linked_list {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(5, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(3,node3);
        ListNode node5 = new ListNode(2, node4);

        middleNode(node5);
    }

    public static  ListNode middleNode(ListNode head) {

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        ListNode fastNode = fakeHead;
        ListNode slowNode = fastNode;
        while (fastNode != null ) {
            slowNode =slowNode.next;
            fastNode = fastNode.next;
            if(fastNode == null){
                return slowNode;
            }
            fastNode = fastNode.next;
        }

        return slowNode;

    }
}
