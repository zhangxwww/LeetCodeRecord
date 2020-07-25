/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    private int[][][] _dp;
    private String ss1, ss2;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        if (n != s2.length()) {
            return false;
        }
        ss1 = s1;
        ss2 = s2;
        _dp = new int[n][n][n + 1];
        return dp(0, 0, n);
    }

    private boolean dp(int i, int j, int l) {
        if (_dp[i][j][l] != 0) {
            return _dp[i][j][l] > 0;
        }
        boolean res = false;
        if (l == 1) {
            res = ss1.charAt(i) == ss2.charAt(j);
        } else {
            for (int k = 1; k < l; ++k) {
                if (dp(i, j, k) && dp(i + k, j + k, l - k)) {
                    res = true;
                    break;
                }
                if (dp(i, j + l - k, k) && dp(i + k, j, l - k)) {
                    res = true;
                    break;
                }
            }
        }
        _dp[i][j][l] = res ? 1 : -1;
        return res;
    }
}
// @lc code=end
