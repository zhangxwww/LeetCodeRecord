import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<Integer> tmp = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                ++nextLevelCount;
            }
            if (node.right != null) {
                q.offer(node.right);
                ++nextLevelCount;
            }
            --currentLevelCount;
            if (currentLevelCount == 0) {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        return res;
    }
}
// @lc code=end
