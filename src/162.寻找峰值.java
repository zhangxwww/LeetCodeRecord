/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid])
            && (mid == len - 1 || nums[mid + 1] < nums[mid])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return mid;
    }
}
// @lc code=end
