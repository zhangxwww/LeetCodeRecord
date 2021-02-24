/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean end = false;
    }

    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node p) {
        if (index == word.length()) {
            return p.end;
        }
        char c = word.charAt(index);
        if (c != '.') {
            int i = c - 'a';
            if (p.children[i] != null) {
                return search(word, index + 1, p.children[i]);
            }
            return false;
        } else {
            for (Node pp : p.children) {
                if (pp != null) {
                    if (search(word, index + 1, pp)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */
// @lc code=end
