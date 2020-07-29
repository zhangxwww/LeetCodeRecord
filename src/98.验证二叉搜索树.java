/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return valid(root, new int[2]);
    }

    private boolean valid(TreeNode root, int[] range) {
        if (root.left == null) {
            range[0] = root.val;
        } else {
            if (root.left.val >= root.val) {
                return false;
            }
            int[] r = new int[2];
            if (valid(root.left, r)) {
                if (r[1] < root.val) {
                    range[0] = r[0];
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (root.right == null) {
            range[1] = root.val;
        } else {
            if (root.right.val <= root.val) {
                return false;
            }
            int[] r = new int[2];
            if (valid(root.right, r)) {
                if (r[0] > root.val) {
                    range[1] = r[1];
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
