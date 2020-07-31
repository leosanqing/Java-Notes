package com.leosanqing.leetcode.medium.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 下午2:50
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `         https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @Version: 1.0
 */
public class _116_populating_next_right_pointers_in_each_node {

    public static void main(String[] args) {
        Node treeNode = new Node(1);
        treeNode.left = new Node(2);
        treeNode.right = new Node(3);
        treeNode.left.left = new Node(4);
        treeNode.left.right = new Node(5);
        treeNode.right.left = new Node(6);
        treeNode.right.right = new Node(7);
        
        connect(treeNode);
    }

    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int queueSize = queue.size() - 1;
            Node node = queue.poll();

            // because of perfect binary tree
            if (node == null) {
                break;
            }

            for (int i = 0; i <= queueSize; i++) {
                queue.offer(node.left);
                queue.offer(node.right);

                if (i == queueSize) {
                    node.next = null;
                    break;
                }

                Node temp = queue.poll();
                node.next = temp;
                node = temp;
            }
        }
        return root;
    }


}
