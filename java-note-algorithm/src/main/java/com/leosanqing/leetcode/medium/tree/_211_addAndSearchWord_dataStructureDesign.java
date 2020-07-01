package com.leosanqing.leetcode.medium.tree;

/**
 * @Author: rtliu
 * @Date: 2020/6/28 下午3:58
 * @Package: com.leosanqing.leetcode.medium.tree
 * @Description: Design a data structure that supports the following two operations:
 *              void addWord(word) bool search(word) search(word) can search a literal word
 *              or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *      Example:
 *          addWord("bad")
 *          addWord("dad")
 *          addWord("mad")
 *          search("pad") -> false
 *          search("bad") -> true
 *          search(".ad") -> true
 *          search("b..") -> true
 * @Version: 1.0
 */
public class _211_addAndSearchWord_dataStructureDesign {

}

class WordDictionary {
    TrieNode1 root = new TrieNode1();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode1 curr = root;
        if(word != null && word.length() > 0){

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode1();
                }
                curr = curr.children[c -'a'];

            }
            curr.isEnd = true;

        }
    }

    /** Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0 , root);
    }


    private boolean helper(String word, int index, TrieNode1 curr){
        if(index >= word.length()){
            return curr.isEnd;
        }
        char c = word.charAt(index);

        if('.' == c){
            for (int i = 0; i < curr.children.length; i++) {
                // 当出现 . 的时候，递归遍历
                if(curr.children[i] != null && helper(word, index+1, curr.children[i])){
                    return true;
                }
            }
            return false;
        }else {
            return (curr.children[c - 'a'] != null) && helper(word,index +1, curr.children[c - 'a']);
        }
    }
}

class TrieNode1 {
    TrieNode1[] children = new TrieNode1[26];

    boolean isEnd = false;

}


