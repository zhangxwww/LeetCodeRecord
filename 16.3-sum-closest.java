/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (42.05%)
 * Total Accepted:    321.9K
 * Total Submissions: 734.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        sort(nums, 0, len - 1);
        int closest = 0x7fffffff;
        int delta = 0x7fffffff;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (sum - target < delta) {
                        closest = sum;
                        delta = sum - target;
                    }
                    --k;
                } else if (sum < target) {
                    if (target - sum < delta) {
                        closest = sum;
                        delta = target - sum;
                    }
                    ++j;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }

    private void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[low];
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
