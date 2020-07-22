import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] path;

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        int n = nums.length;
        for (int k = 1; k <= n; ++k) {

            path = new int[k];
            for (int i = 0; i < n; ++i) {
                dfs(i, k - 1, n, nums);
            }
        }
        return res;
    }

    private void dfs(int start, int k, int n, int[] nums) {
        path[path.length - k - 1] = nums[start];
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
            dfs(i, k - 1, n, nums);
        }
    }
}
// @lc code=end
