import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] path;
    private Set<List<Integer>> used = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
        Arrays.sort(nums);
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
            if (!used.contains(r)) {
                res.add(r);
                used.add(r);
            }
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
