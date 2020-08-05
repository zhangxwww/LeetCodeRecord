/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i : nums) {
            a = (a ^ i) & ~b;
            b = (b ^ i) & ~a;
        }
        return a;
    }
}
// @lc code=end
