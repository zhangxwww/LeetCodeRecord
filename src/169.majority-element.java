/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (51.90%)
 * Total Accepted:    365.8K
 * Total Submissions: 702.7K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int can = nums[0];
        int count = 1;
        int len = nums.length;
        int startPos = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == can) {
                count++;
            } else {
                if (count * 2 <= i + 1 - startPos) {
                    count = 0;
                    startPos = i + 1;
                    can = nums[i + 1];
                }
            }
        }
        return can;
    }
}
