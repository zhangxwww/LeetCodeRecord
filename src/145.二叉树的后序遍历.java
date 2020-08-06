import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        s.push(root);
        TreeNode p = null;
        while (p != null || !s.empty()) {
            if (p == null) {
                p = s.pop();
            }
            res.add(p.val);
            if (p.left != null) {
                s.push(p.left);
            }
            p = p.right;
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end
