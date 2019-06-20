/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int len = nums.length;
        return (len + 1) * len / 2 - sum;
    }
}
