/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int sum = nums[0];
        int left = 0;
        int right = 1;
        int res = n + 1;
        boolean found = false;
        if (sum >= s) {
            res = 1;
            found = true;
        }
        while (left <= right && right < n) {
            if (sum < s) {
                sum += nums[right++];
            } else if (sum > s) {
                sum -= nums[left++];
            } else {
                sum += nums[right++] - nums[left++];
            }
            if (sum >= s) {
                int len = right - left;
                if (len < res) {
                    res = len;
                    found = true;
                }
            }
        }
        while (sum >= s && left < n) {
            sum -= nums[left++];
            if (sum >= s) {
                int len = right - left;
                if (len < res) {
                    res = len;
                    found = true;
                }
            }
        }
        return found ? res : 0;
    }
}
// @lc code=end
