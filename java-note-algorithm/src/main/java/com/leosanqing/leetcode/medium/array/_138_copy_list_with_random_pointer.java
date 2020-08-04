package com.leosanqing.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: rtliu
 * @Date: 2020/8/4 上午11:30
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: https://leetcode.com/problems/copy-list-with-random-pointer/
 * @Version: 1.0
 */
public class _138_copy_list_with_random_pointer {
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();



        RandomListNode node = head;
        while(node !=null){
            map.put(node,new RandomListNode(node.val));
            node = node.next;
        }

        node = head;

        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}


class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}