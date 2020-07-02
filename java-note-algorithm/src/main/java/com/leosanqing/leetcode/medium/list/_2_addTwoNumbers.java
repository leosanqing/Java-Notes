package com.leosanqing.leetcode.medium.list;

/**
 * @Author: rtliu
 * @Date: 2020/7/2 下午4:54
 * @Package: com.leosanqing.leetcode.medium.list
 * @Description: ` `     You are given two non-empty linked lists representing two non-negative integers.
 * ` `     The digits are stored in reverse order and each of their nodes contain a single digit.
 * ` `     Add the two numbers and return it as a linked list.
 * ` `     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * ` `     您将获得两个表示两个非负整数的非空链表。
 * ` `     这些数字以相反的顺序存储，并且它们的每个节点都包含一个数字。
 * ` `     将两个数字相加并作为链接列表返回。
 * ` `     您可以假设两个数字除了数字0本身以外，都不包含任何前导零。
 * <p>
 * ` `  Example:
 * ` `     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * ` `     Output: 7 -> 0 -> 8
 * ` `     Explanation: 342 + 465 = 807.
 * @Version: 1.0
 */
public class _2_addTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(6, node2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1, node4);
        ListNode node6 = new ListNode(3, node5);

        _2_addTwoNumbers addTwoNumbers = new _2_addTwoNumbers();
        addTwoNumbers.addTwoNumbers(node3, node6);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        // 新建一个链表
        ListNode result = new ListNode();
        ListNode curr = result;

        int sum = 0;
        // 进位
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            // 如果链1 和 链2 没有位数了
            if (curr1 == null) {
                curr1 = new ListNode(0);
            }
            if (curr2 == null) {
                curr2 = new ListNode(0);
            }

            sum = curr1.val + curr2.val + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // 如果最高位加起来大于10，就需要新来一个节点
        if (carry != 0) {
            curr.next = new ListNode(1);
        }
        return result.next;

    }
}

 class ListNode {
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
