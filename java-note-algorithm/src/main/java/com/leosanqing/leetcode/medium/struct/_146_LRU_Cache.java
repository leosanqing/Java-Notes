package com.leosanqing.leetcode.medium.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * @author: rtliu
 * @date: 2021/4/25 9:57 上午
 */
public class _146_LRU_Cache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        System.out.println(lruCache.get(2));
    }

    static class DLinkedNode {
        int value;
        int key;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    static class LRUCache {
        private Map<Integer, DLinkedNode> map = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            // 使用虚拟的头尾节点,防止出现极限问题
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                DLinkedNode dLinkedNode = new DLinkedNode(key, value);
                map.put(key, dLinkedNode);

                // 设置 头节点
                addToHead(dLinkedNode);

                ++size;
                if (size > capacity) {
                    map.remove(removeTail().key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private DLinkedNode removeTail() {
            DLinkedNode pre = tail.pre;
            removeNode(pre);
            return pre;
        }

        private void removeNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(DLinkedNode dLinkedNode) {
            dLinkedNode.pre = head;
            dLinkedNode.next = head.next;

            head.next.pre = dLinkedNode;
            head.next = dLinkedNode;
        }

        private void moveToHead(DLinkedNode dLinkedNode) {
            removeNode(dLinkedNode);
            addToHead(dLinkedNode);
        }
    }
}
