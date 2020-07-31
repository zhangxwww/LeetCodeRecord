import java.util.Stack;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        TreeNode prev = null;
        while (true) {
            if (p == null) {
                if (s.empty()) {
                    break;
                }
                p = s.pop();
            }
            if (prev != null) {
                prev.right = p;
            }
            if (p.right != null) {
                s.push(p.right);
            }
            prev = p;
            p = p.left;
            prev.left = null;
        }
    }
}
// @lc code=end
