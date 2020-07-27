import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> r = new ArrayList<>();
        if (start == end) {
            TreeNode t = new TreeNode(start);
            r.add(t);
        } else {
            List<TreeNode> tmp;
            tmp = buildTree(start + 1, end);
            for (TreeNode t : tmp) {
                r.add(new TreeNode(start, null, t));
            }
            tmp = buildTree(start, end - 1);
            for (TreeNode t : tmp) {
                r.add(new TreeNode(end, t, null));
            }
            for (int i = start + 1; i < end; ++i) {
                List<TreeNode> leftTmp = buildTree(start, i - 1);
                List<TreeNode> rightTmp = buildTree(i + 1, end);
                int nleft = leftTmp.size();
                int nright = rightTmp.size();
                for (int j = 0; j < nleft; ++j) {
                    for (int k = 0; k < nright; ++k) {
                        r.add(new TreeNode(i, leftTmp.get(j), rightTmp.get(k)));
                    }
                }
            }
        }
        return r;
    }
}
// @lc code=end
