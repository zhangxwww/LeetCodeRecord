/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean end = false;
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new Node();
            }
            p = p.children[index];
        }
        p.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
