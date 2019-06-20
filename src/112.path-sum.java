/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (37.29%)
 * Total Accepted:    299.8K
 * Total Submissions: 801.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \      \
 * 7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Stack;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<Integer> sums = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        sums.push(root.val);
        nodes.push(root);
        while (sums.size() > 0) {
            TreeNode node = nodes.pop();
            int s = sums.pop();
            if (s == sum && node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null) {
                nodes.push(node.left);
                sums.push(node.left.val + s);
            }
            if (node.right != null) {
                nodes.push(node.right);
                sums.push(node.right.val + s);
            }
        }
        return false;
    }
}
