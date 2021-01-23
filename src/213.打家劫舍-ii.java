/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] d = new int[n];
        int[] e = new int[n];
        d[n - 2] = nums[n - 2];
        e[1] = nums[1];
        for (int i = n - 3; i >= 0; i--) {
            d[i] = Math.max(nums[i] + d[i + 2], d[i + 1]);
        }
        for (int i = 2; i < n; i++) {
            e[i] = Math.max(nums[i] + e[i - 2], e[i - 1]);
        }
        return Math.max(d[0], e[n - 1]);
    }
}
// @lc code=end
