/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] delta = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            delta[i] = gas[i] - cost[i];
            sum += delta[i];
        }
        if (sum < 0) {
            return -1;
        }
        for (int start = 0; start < n; ++start) {
            sum = 0;
            boolean cant = false;
            for (int j = start; j < start + n; ++j) {
                sum += delta[j % n];
                if (sum < 0) {
                    cant = true;
                    break;
                }
            }
            if (!cant) {
                return start;
            }
        }
        return -1;
    }
}
// @lc code=end
