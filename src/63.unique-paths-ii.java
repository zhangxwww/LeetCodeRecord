/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                } else if (i == 0) {
                    map[0][j] = map[0][j - 1];
                } else if (j == 0) {
                    map[i][0] = map[i - 1][0];
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[n - 1][m - 1];
    }
}
// @lc code=end
