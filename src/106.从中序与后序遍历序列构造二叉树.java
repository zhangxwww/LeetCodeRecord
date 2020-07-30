/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, 0, inorder.length);
    }

    private TreeNode build(int[] inorder, int[] postorder, int instart, int poststart, int len) {
        if (len == 0) {
            return null;
        }
        int rootVal = postorder[poststart + len - 1];
        int rootPosInInorder = -1;
        for (int i = instart; i < len + instart; ++i) {
            if (inorder[i] == rootVal) {
                rootPosInInorder = i;
            }
        }
        int leftLen = rootPosInInorder - instart;
        int rightLen = len - leftLen - 1;
        TreeNode root = new TreeNode(rootVal);
        if (leftLen != 0) {
            root.left = build(inorder, postorder, instart, poststart, leftLen);
        }
        if (rightLen != 0) {
            root.right = build(inorder, postorder, instart + 1 + leftLen, poststart + leftLen, rightLen);
        }
        return root;
    }
}
// @lc code=end
