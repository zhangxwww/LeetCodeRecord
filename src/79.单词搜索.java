/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        used = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dfs(board, word, i, j, n, m, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int n, int m, int level) {
        if (board[row][col] != word.charAt(level)) {
            return false;
        }
        int wlen = word.length();
        if (level == wlen - 1) {
            return true;
        }
        used[row][col] = true;
        if (row > 0 && !used[row - 1][col]) {
            if (dfs(board, word, row - 1, col, n, m, level + 1)) {
                return true;
            }
        }
        if (row < n - 1 && !used[row + 1][col]) {
            if (dfs(board, word, row + 1, col, n, m, level + 1)) {
                return true;
            }
        }
        if (col > 0 && !used[row][col - 1]) {
            if (dfs(board, word, row, col - 1, n, m, level + 1)) {
                return true;
            }
        }
        if (col < m - 1 && !used[row][col + 1]) {
            if (dfs(board, word, row, col + 1, n, m, level + 1)) {
                return true;
            }
        }
        used[row][col] = false;
        return false;
    }
}
// @lc code=end
