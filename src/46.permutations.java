
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        f(nums, 0, res);
        return res;
    }

    private void f(int[] nums, int depth, List<List<Integer>> res) {
        if (depth == nums.length - 1) {
            List<Integer> r = new ArrayList<>();
            for (int i : nums) {
                r.add(i);
            }
            res.add(r);
            return;
        }
        for (int i = depth; i < nums.length; ++i) {
            swap(nums, i, depth);
            f(nums, depth + 1, res);
            swap(nums, i, depth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
