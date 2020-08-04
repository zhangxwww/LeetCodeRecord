/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        boolean[][] pa = new boolean[n][n];
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            d[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || pa[i - 1][j + 1]) {
                        pa[i][j] = true;
                        d[i] = j == 0 ? 0 : Math.min(d[i], d[j - 1] + 1);
                    }
                }
            }
        }
        return d[n - 1];
    }
}
// @lc code=end
