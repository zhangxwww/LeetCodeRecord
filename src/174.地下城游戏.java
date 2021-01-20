/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] a = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    a[i][j] = Math.max(0, -dungeon[i][j]);
                } else if (i == n - 1) {
                    a[i][j] = Math.max(0, a[i][j + 1] - dungeon[i][j]);
                } else if (j == m - 1) {
                    a[i][j] = Math.max(0, a[i + 1][j] - dungeon[i][j]);
                } else {
                    a[i][j] = Math.max(0, Math.min(a[i + 1][j], a[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return a[0][0] + 1;
    }
}
// @lc code=end
