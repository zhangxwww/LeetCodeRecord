import java.util.Collections;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<Integer> tmp = new ArrayList<>();
        boolean reverse = false;
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
                if (reverse) {
                    Collections.reverse(tmp);
                }
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                reverse = !reverse;
            }
        }
        return res;
    }
}
// @lc code=end
