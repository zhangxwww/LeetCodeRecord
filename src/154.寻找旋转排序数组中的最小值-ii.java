/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[i] == nums[j]) {
                if (nums[i] == nums[m]) {
                    boolean flat = true;
                    for (int k = i + 1; k < j; k++) {
                        if (nums[k] != nums[i]) {
                            flat = false;
                            if (nums[k] < nums[i]) {
                                return nums[k];
                            } else {
                                i = k;
                                break;
                            }
                        }
                    }
                    if (flat) {
                        return nums[i];
                    }
                } else if (nums[i] < nums[m]) {
                    i = m;
                } else {
                    j = m;
                }
            } else if (nums[i] < nums[j]) {
                return nums[i];
            } else {
                if (i == m) {
                    return nums[j];
                } else if (nums[i] == nums[m]) {
                    i = m;
                } else if (nums[i] > nums[m]) {
                    j = m;
                } else {
                    i = m;
                }
            }
        }
        return nums[i];
    }
}
// @lc code=end
