package com.leosanqing.leetcode.medium.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: rtliu
 * @Date: 2020/6/17 上午10:33
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: 实现 一个 Trie
 *               Implement a trie with insert, search, and startsWith methods.
 *
 *  Example:
 *
 *          Trie trie = new Trie();
 *
 *          trie.insert("apple");
 *          trie.search("apple");   // returns true
 *          trie.search("app");     // returns false
 *          trie.startsWith("app"); // returns true
 *          trie.insert("app");
 *          trie.search("app");     // returns true
 *
 *
 *          很多人可能不了解 Trie
 *    在计算机科学中，trie，又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。
 *    与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。
 *    一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。
 *    一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。
 * @Version: 1.0
 */
public class _208_implementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        System.out.println(apple);
    }
}

class TrieNode{
    private final Map<Character,TrieNode> children = new HashMap<>();

    public boolean isEnd = false;

    public void putChildIfAbsent(char c){
        // 直接调用 HashMap 的代码，创建 子节点
        children.putIfAbsent(c,new TrieNode());
    }

    public TrieNode getChildren(char c){
        return children.get(c);
    }
}

class Trie {


    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChildren(ch);
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.getChildren(ch);
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.getChildren(c);
            if (curr == null) {
                return false;
            }
        }

        return true;
    }
}
