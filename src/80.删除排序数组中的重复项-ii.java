
/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int newLength = 1;
        int duplicateCount = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[newLength - 1]) {
                nums[newLength++] = nums[i];
                duplicateCount = 0;
            } else {
                ++duplicateCount;
                if (duplicateCount < 2) {
                    nums[newLength++] = nums[i];
                }
            }
        }
        return newLength;
    }
}
// @lc code=end
