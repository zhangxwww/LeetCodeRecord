/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int cur = 0;
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        while (true) {
            ++count;
            if (cur >= n) {
                return count;
            }
            int max = nums[cur];
            if (max + cur >= n - 1) {
                return count;
            }
            int maxPos = 0;
            int next = cur;
            for (int i = 0; i <= max; ++i) {
                if (cur + i >= n) {
                    next = n;
                    break;
                }
                int pos = nums[cur + i] + i;
                if (pos > maxPos) {
                    maxPos = pos;
                    next = cur + i;
                }
            }
            cur = next;
        }
    }
}
