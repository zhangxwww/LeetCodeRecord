import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        TreeNode next;
        int maxDepth = 0;
        while (true) {
            s.push(cur);
            if (s.size() > maxDepth) {
                res.add(cur.val);
                maxDepth = s.size();
            }
            if (cur.right != null) {
                next = cur.right;
                cur.right = null;
                cur = next;
            } else if (cur.left != null) {
                next = cur.left;
                cur.left = null;
                cur = next;
            } else {
                cur = s.pop();
                while (s.size() > 0) {
                    if (cur.left == null && cur.right == null) {
                        cur = s.pop();
                    } else {
                        break;
                    }
                }
                if (s.size() == 0 && cur.left == null && cur.right == null) {
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end
