/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int left = -1;
        if (low < n && nums[low] == target) {
            left = low;
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int right = -1;
        if (high >= 0 && nums[high] == target) {
            right = high;
        }
        return new int[] { left, right };
    }
}
