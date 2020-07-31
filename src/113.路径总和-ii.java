import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    Stack<Integer> s = new Stack<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, 0, sum);
        return res;
    }

    private void dfs(TreeNode root, int cur, int sum) {
        s.push(root.val);
        cur += root.val;
        if (cur == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(s));
        } else {
            if (root.left != null) {
                dfs(root.left, cur, sum);
            }
            if (root.right != null) {
                dfs(root.right, cur, sum);
            }
        }
        s.pop();
    }
}
// @lc code=end
