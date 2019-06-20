/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (i != p) {
                    nums[p] = nums[i];
                }
                ++p;
            }
        }
        for (; p < len; p++) {
            nums[p] = 0;
        }
    }
}
