import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> ret = dfs(k, n, i, 1);
            res.addAll(ret);
        }
        return res;
    }

    List<List<Integer>> dfs(int k, int n, int i, int depth) {
        List<List<Integer>> res = new ArrayList<>();
        if (depth == k) {
            if (n == i) {
                List<Integer> r = new ArrayList<>();
                r.add(i);
                res.add(r);
            }
        } else {
            if (n > i) {
                for (int j = i + 1; j < 10; j++) {
                    List<List<Integer>> ret = dfs(k, n - i, j, depth + 1);
                    for (List<Integer> r : ret) {
                        r.add(i);
                        res.add(r);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
