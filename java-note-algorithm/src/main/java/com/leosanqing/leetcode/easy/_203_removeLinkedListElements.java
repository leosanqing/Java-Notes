package com.leosanqing.leetcode.easy;

import com.leosanqing.leetcode.medium.list.ListNode;

/**
 * @Author: rtliu
 * @Date: 2020/6/1 下午2:11
 * @Package: easy
 * @Description: Remove all elements from a linked list of integers that have value val.
 * 删除链表中与指定值相同的节点
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @Version: 1.0
 */
public class _203_removeLinkedListElements {
    public static void main(String[] args) {

    }

    /**
     * 使用一个虚拟的头结点来预防边界异常情况
     *
     * 如果
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟的头结点，就把 特殊的边界节点变成了普通的节点
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;


        while(pre.next != null){
            //  直接把上一个节点指向 下一个节点，从而跳过当前节点 ，这样就达到了删除的目的 1->2->6->3->4->5->6, val = 6
            if(val == pre.next.val){
                pre.next = pre.next.next;
            }else {
//            if (pre.next.val == val) pre.next = pre.next.next;
                pre = pre.next;
            }
        }
        return fakeHead.next;
    }


}
