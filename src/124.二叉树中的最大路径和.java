/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int maxSum;

    private int localD;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        visit(root);
        return maxSum;
    }

    private void visit(TreeNode root) {
        int leftD = 0, rightD = 0;
        if (root.left != null) {
            visit(root.left);
            leftD = localD;
        }
        if (root.right != null) {
            visit(root.right);
            rightD = localD;
        }
        int rootval = root.val;
        int c = rootval + leftD + rightD;
        localD = rootval + max(0, max(leftD, rightD));
        maxSum = max(maxSum, max(c, localD));
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
// @lc code=end
