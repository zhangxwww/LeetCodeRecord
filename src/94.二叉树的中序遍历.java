import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        while (true) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                if (s.empty()) {
                    break;
                }
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
// @lc code=end
