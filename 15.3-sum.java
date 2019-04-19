import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.66%)
 * Total Accepted:    523.5K
 * Total Submissions: 2.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        sort(nums, 0, len - 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    --k;
                } else if (sum < 0) {
                    ++j;
                } else {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    res.add(r);
                    do {
                        --k;
                    } while (j < k && nums[k] == nums[k + 1]);
                    do {
                        ++j;
                    } while (j < k && nums[j] == nums[j - 1]);
                }
            }
        }
        return res;
    }

    private void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) {
                --j;
            }
            a[i] = a[j];
            while (i < j && a[i] <= x) {
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = x;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
}
