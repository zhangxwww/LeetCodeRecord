/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (49.75%)
 * Total Accepted:    249.6K
 * Total Submissions: 499.7K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        build(root, nums, 0, len - 1);
        return root;
    }

    private void build(TreeNode root, int[] nums, int start, int end) {
        if (start == end) {
            root.val = nums[start];
            return;
        }
        int mid = (end + start) / 2;
        root.val = nums[mid];
        if (start <= mid - 1) {
            root.left = new TreeNode(0);
            build(root.left, nums, start, mid - 1);
        }
        if (end >= mid + 1) {
            root.right = new TreeNode(0);
            build(root.right, nums, mid + 1, end);
        }
    }
}
