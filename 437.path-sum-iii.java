/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return count(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int count(TreeNode root, int pre, int sum) {
        if (root == null) {
            return 0;
        }
        int cur = pre + root.val;
        int c = count(root.left, cur, sum) + count(root.right, cur, sum);
        if (cur == sum) {
            return c + 1;
        } else {
            return c;
        }
    }
}
