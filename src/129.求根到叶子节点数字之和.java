/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int cur) {
        int c = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += c;
            return;
        }
        if (root.left != null) {
            dfs(root.left, c);
        }
        if (root.right != null) {
            dfs(root.right, c);
        }
    }
}
// @lc code=end
