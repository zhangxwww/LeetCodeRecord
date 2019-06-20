/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.List;
import java.util.Vector;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        Vector<Integer> path = new Vector<>();
        dfs(path, 1, root, list);
        return list;
    }

    private void dfs(Vector<Integer> path, int depth, TreeNode root, List<String> list) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(root.val);
            list.add(sb.toString());
        }
        if (path.size() < depth) {
            path.add(root.val);
        } else {
            path.set(depth - 1, root.val);
        }
        if (root.left != null) {
            dfs(path, depth + 1, root.left, list);
        }
        if (root.right != null) {
            dfs(path, depth + 1, root.right, list);
        }
    }
}
