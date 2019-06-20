/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            s += root.left.val;
        } else if (root.left != null) {
            s += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            s += sumOfLeftLeaves(root.right);
        }
        return s;
    }
}
