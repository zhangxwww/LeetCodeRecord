import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode p = null;
        while (p != null || !s.empty()) {
            if (p == null) {
                p = s.pop();
            }
            res.add(p.val);
            if (p.right != null) {
                s.push(p.right);
            }
            p = p.left;
        }
        return res;
    }
}
// @lc code=end
