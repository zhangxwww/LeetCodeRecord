/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length - 1;
        if (n < 1) {
            return 0;
        }
        int[] delta = new int[n];
        for (int i = 0; i < n; ++i) {
            delta[i] = prices[i + 1] - prices[i];
        }

        int[] m = new int[n];
        int[] d = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int sum = delta[i];
            int maxSum = sum;
            if (i == 0) {
                d[0] = sum;
            }
            for (int j = i + 1; j < n; ++j) {
                sum = sum > 0 ? sum + delta[j] : delta[j];
                maxSum = max(maxSum, sum);
                if (i == 0) {
                    d[j] = sum;
                }
            }
            m[i] = maxSum;
        }

        int res = max(m[0], 0);
        for (int i = 0; i < n - 1; ++i) {
            res = max(res, d[i] + m[i + 1]);
        }
        return res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
// @lc code=end
