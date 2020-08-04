package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 下午4:50
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: 1
 *`          Given a linked list, return the node where the cycle begins.
 *`          If there is no cycle, return null.
 *`          To represent a cycle in the given linked list,
 *`          we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 *`          If pos is -1, then there is no cycle in the linked list.
 *`          Note: Do not modify the linked list.
 *`      Example 1:
 *`          Input: head = [3,2,0,-4], pos = 1
 *`          Output: tail connects to node index 1
 *`          Explanation:
 *`              There is a cycle in the linked list, where tail connects to the second node.
 *`      Example 2:
 *`         Input: head = [1,2], pos = 0
 *`         Output: tail connects to node index 0
 *`         Explanation:
 *`              There is a cycle in the linked list, where tail connects to the first node.
 * @Version: 1.0
 */
public class _142_linked_list_cycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
