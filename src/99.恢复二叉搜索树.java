/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode cur = null, next = null, prev = null;
        if (root == null) {
            return;
        }
        cur = root;
        while (cur != null) {
            next = cur.left;
            if (next != null) {
                while (next.right != null && next.right != cur) {
                    next = next.right;
                }
                if (next.right == null) {
                    next.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    next.right = null;
                }
            }
            if (prev != null && prev.val > cur.val) {
                if (first == null) {
                    first = prev;
                }
                second = cur;
            }
            prev = cur;
            cur = cur.right;
        }
        if (first != null && second != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }
}
// @lc code=end
