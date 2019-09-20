
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        HashSet<List<Integer>> s = new HashSet<>();
        f(nums, 0, s);
        List<List<Integer>> res = new ArrayList<>(s);
        return res;
    }

    private void f(int[] nums, int depth, HashSet<List<Integer>> s) {
        if (depth == nums.length - 1) {
            List<Integer> r = new ArrayList<>();
            for (int i : nums) {
                r.add(i);
            }
            if (!s.contains(r)) {
                s.add(r);
            }
            return;
        }
        for (int i = depth; i < nums.length; ++i) {
            swap(nums, i, depth);
            f(nums, depth + 1, s);
            swap(nums, i, depth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
