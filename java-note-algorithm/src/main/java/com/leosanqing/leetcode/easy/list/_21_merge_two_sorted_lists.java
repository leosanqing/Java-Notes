package com.leosanqing.leetcode.easy.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/7 下午4:46
 * @Package: com.leosanqing.leetcode.easy.list
 * @Description: Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * @Version: 1.0
 */
public class _21_merge_two_sorted_lists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(1,node2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3,node4);
        ListNode node6 = new ListNode(1,node5);

        System.out.println(mergeTwoLists(node3,node6));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return new ListNode();
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode newList = new ListNode();
        ListNode fakeHead = newList;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                newList.next = curr1;
                curr1 = curr1.next;
            }else {
                newList.next = curr2;
                curr2 = curr2.next;
            }
            newList = newList.next;
        }

        if(curr1 != null){
            newList.next = curr1;
        }
        if(curr2 != null){
            newList.next = curr2;
        }

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
