/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int prestart, int instart, int len) {
        if (len == 0) {
            return null;
        }
        int rootVal = preorder[prestart];
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
            root.left = build(preorder, inorder, prestart + 1, instart, leftLen);
        }
        if (rightLen != 0) {
            root.right = build(preorder, inorder, prestart + 1 + leftLen, instart + 1 + leftLen, rightLen);
        }
        return root;
    }
}
// @lc code=end
