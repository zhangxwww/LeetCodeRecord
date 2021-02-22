/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (nums[i] < nums[j]) {
                return nums[i];
            } else {
                int mid = (i + j) / 2;
                if (nums[mid] > nums[i]) {
                    i = mid;
                } else if (nums[mid] < nums[j]) {
                    j = mid;
                } else {
                    return nums[j];
                }
            }
        }
        return nums[i];
    }
}
// @lc code=end
