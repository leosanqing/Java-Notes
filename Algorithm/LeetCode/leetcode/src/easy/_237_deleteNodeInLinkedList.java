package easy;

/**
 * 描述：Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 *      Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *      请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 *      现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5,
 *              the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 *
 *
 * 提示：你已经进入了那个节点，并不是从头开始。
 *      链表至少包含两个节点。
 *      链表中所有节点的值都是唯一的。
 *      给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 *      不要从你的函数中返回任何结果。
 *
 *      请一定要注意描述和提示！！！！
 *
 *
 * 解法： 直接用后面的覆盖前面的，然后将指针修改下就行
 */

public class _237_deleteNodeInLinkedList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }
    }

    public static void main(String[] args) {

    }
    public static void deleteNode(ListNode node){
        // 覆盖
        node.val = node.next.val;
        // 修改指针
        node.next = node.next.next;
    }
}
