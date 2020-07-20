/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    map[i][j] += map[i - 1][j] < map[i][j - 1] ? map[i - 1][j] : map[i][j - 1];
                } else if (i > 0) {
                    map[i][j] += map[i - 1][j];
                } else if (j > 0) {
                    map[i][j] += map[i][j - 1];
                }
            }
        }
        return map[n - 1][m - 1];
    }
}
// @lc code=end
