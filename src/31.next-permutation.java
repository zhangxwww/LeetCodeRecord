/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        int i = n - 2;
        for (; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            transpose(nums, 0, n - 1);
            return;
        }
        int j = i + 1;
        int k = n - 1;
        for (; k >= j; --k) {
            if (nums[k] > nums[i]) {
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                transpose(nums, j, n - 1);
                break;
            }
        }
    }

    private void transpose(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}
