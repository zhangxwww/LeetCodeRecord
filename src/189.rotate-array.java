/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (29.37%)
 * Total Accepted:    283.2K
 * Total Submissions: 958.2K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        k %= len;
        int start = 0;
        int pos = 0;
        int cur = nums[pos];
        int pre = 0;
        for (int i = 0; i < len; i++) {
            pre = cur;
            pos = (pos + k) % len;
            cur = nums[pos];
            nums[pos] = pre;
            if (start == pos) {
                start++;
                pos = start;
                cur = nums[pos % len];
            }
        }
    }
}
