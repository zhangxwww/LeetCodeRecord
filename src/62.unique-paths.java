/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {

    private int[] fact;
    private int[][] map;

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        map = new int[n + m][m > n ? m : n];
        callFact();
        return C(m + n - 2, m - 1);
    }

    private int C(int n, int m) {
        if (2 * m > n) {
            m = n - m;
        }
        if (m == 0) {
            return 1;
        }
        if (m == 1) {
            return n;
        }
        if (map[n][m] != 0) {
            return map[n][m];
        }
        int res = 0;
        if (n <= 12) {
            res = fact[n] / fact[m];
        }
        int t1 = (map[n - 1][m - 1] == 0) ? C(n - 1, m - 1) : map[n - 1][m - 1];
        int t2 = (map[n - 1][m] == 0) ? C(n - 1, m) : map[n - 1][m];
        res = t1 + t2;
        map[n][m] = res;
        return res;
    }

    private void callFact() {
        fact = new int[13];
        fact[0] = 1;
        for (int i = 1; i < 13; ++i) {
            fact[i] = fact[i - 1] * i;
        }
    }
}
// @lc code=end
