package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-08 22:04
 * <p>
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class _6_PrintListFromTailToHead {
    public static void main(String[] args) {
        Node head = new Node(4);
        Node node1 = new Node(7);
        Node node2 = new Node(65);
        Node node3 = new Node(2);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(1);
        node5.setNext(node6);
        node4.setNext(node5);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);
        head.setNext(node1);
        method(head);
    }


    /**
     * 使用递归来打印
     *
     * 如果像书上使用其他辅助容器，那基本所有容器都可以。
     * @param head 头结点
     */
    private static void method(Node head) {
        if (head != null) {
            if(head.getNext()!=null){
                method(head.getNext());
            }
            System.out.println(head.getKey());
        }
    }


    static class Node {
        private int key;
        private Node next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int key) {
            this.key = key;
        }
    }
}

