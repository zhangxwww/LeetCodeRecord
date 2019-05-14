/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */
class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        long first = Long.MIN_VALUE, sec = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > first) {
                third = sec;
                sec = first;
                first = nums[i];
            } else if (nums[i] == first) {
                continue;
            } else if (nums[i] > sec) {
                third = sec;
                sec = nums[i];
            } else if (nums[i] == sec) {
                continue;
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }
}
