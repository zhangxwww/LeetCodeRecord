/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[][] d = new boolean[n1 + 1][n2 + 1];
        d[0][0] = true;
        for (int i = 0; i <= n1; ++i) {
            for (int j = 0; j <= n2; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                char c = s3.charAt(i + j - 1);
                if (j > 0 && d[i][j - 1] && c == s2.charAt(j - 1)) {
                    d[i][j] = true;
                } else if (i > 0 && d[i - 1][j] && c == s1.charAt(i - 1)) {
                    d[i][j] = true;
                }
            }
        }
        return d[n1][n2];
    }
}
// @lc code=end
