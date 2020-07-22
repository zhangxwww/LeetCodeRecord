import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] path;

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return res;
        }
        path = new int[k];
        for (int i = 0; i < n; ++i) {
            dfs(i, k - 1, n);
        }
        return res;
    }

    private void dfs(int start, int k, int n) {
        path[path.length - k - 1] = start + 1;
        if (k == 0) {
            List<Integer> r = new ArrayList<>();
            for (int p : path) {
                r.add(p);
            }
            res.add(r);
            return;
        }
        if (start + k >= n) {
            return;
        }
        for (int i = start + 1; i < n; ++i) {
            dfs(i, k - 1, n);
        }
    }
}
// @lc code=end
