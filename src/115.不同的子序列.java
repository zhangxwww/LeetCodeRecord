import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] pSum = new int[m];
        int[] cSum = new int[m + 1];
        for (int i = 0; i < n; ++i) {
            cSum[0] = 0;
            for (int j = 0; j < m; ++j) {
                int val = 0;
                if (s.charAt(j) == t.charAt(i)) {
                    val = i == 0 ? 1 : pSum[j];
                }
                cSum[j + 1] = val + cSum[j];
            }
            if (i < n - 1) {
                System.arraycopy(cSum, 0, pSum, 0, m);
            }
        }
        return cSum[m];
    }
}
// @lc code=end
