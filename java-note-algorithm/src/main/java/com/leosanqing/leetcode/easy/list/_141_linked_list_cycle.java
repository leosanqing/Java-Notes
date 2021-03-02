package com.leosanqing.leetcode.easy.list;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 下午4:15
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: 1
 * `          Given a linked list, determine if it has a cycle in it.
 * `          To represent a cycle in the given linked list,
 * `          we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * `          If pos is -1, then there is no cycle in the linked list.
 * `      Example 1:
 * `          Input: head = [3,2,0,-4], pos = 1
 * `          Output: true
 * `          Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * `      Example 2:
 * `          Input: head = [1,2], pos = 0
 * `          Output: true
 * `          Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * @Version: 1.0
 */
public class _141_linked_list_cycle {
    /**
     * 设置两个指针 一个快指针 一个慢指针 ，只要出现两个指针指向的一样，那就说明有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;

    }

}
