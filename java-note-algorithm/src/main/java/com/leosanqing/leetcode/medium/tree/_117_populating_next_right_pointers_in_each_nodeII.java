package com.leosanqing.leetcode.medium.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: rtliu
 * @Date: 2020/7/31 下午3:59
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 1
 * `          https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @Version: 1.0
 */
public class _117_populating_next_right_pointers_in_each_nodeII {
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
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

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
