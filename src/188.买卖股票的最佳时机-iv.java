/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length - 1;
        if (n <= 0) {
            return 0;
        }
        int[][] d = new int[n][k];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = prices[i + 1] - prices[i];
        }
        for (int kk = 0; kk < k; kk++) {
            d[kk][kk] = a[kk] + (kk == 0 ? 0 : d[kk - 1][kk - 1]);
            for (int i = kk + 1; i < n; i++) {
                if (kk == 0) {
                    d[i][kk] = (d[i - 1][kk] > 0 ? d[i - 1][kk] : 0) + a[i];
                } else {
                    int m = 0x80000000;
                    for (int j = kk - 1; j <= i - 1; j++) {
                        m = m > d[j][kk - 1] ? m : d[j][kk - 1];
                    }
                    d[i][kk] = (m > d[i - 1][kk] ? m : d[i - 1][kk]) + a[i];
                }
            }
        }
        int res = 0x80000000;
        for (int kk = 0; kk < k; kk++) {
            for (int i = kk; i < n; i++) {
                if (d[i][kk] > res) {
                    res = d[i][kk];
                }
            }
        }
        return res > 0 ? res : 0;
    }
}
// @lc code=end
