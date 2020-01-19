/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cur = 0;
        while (true) {
            if (cur >= n - 1) {
                return true;
            }
            int nextNum = nums[cur];
            if (nextNum == 0) {
                return false;
            }
            int next = 0;
            int maxPosition = cur;
            for (int i = 1; i <= nextNum; ++i) {
                int p = cur + i;
                if (p >= n) {
                    return true;
                }
                int pos = nums[p] + p;
                if (pos >= maxPosition) {
                    maxPosition = pos;
                    next = p;
                }
            }
            if (cur == next) {
                return false;
            }
            cur = next;
        }
    }
}
// @lc code=end
