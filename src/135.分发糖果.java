/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n < 2) {
            return n;
        }
        int[] d = new int[n];
        d[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                d[i] = d[i - 1] + 1;
            } else {
                d[i] = 1;
            }
        }
        int sum = 0;
        for (int i = n - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i] && d[i - 1] <= d[i]) {
                d[i - 1] = d[i] + 1;
            }
            sum += d[i];
        }
        return sum + d[0];
    }
}
// @lc code=end
