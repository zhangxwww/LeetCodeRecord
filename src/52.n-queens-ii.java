/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private boolean[][] board;
    private boolean[] column;
    private boolean[] l2r;
    private boolean[] r2l;
    private int res = 0;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        column = new boolean[n];
        l2r = new boolean[2 * n - 1];
        r2l = new boolean[2 * n - 1];
        dfs(0, n);
        return res;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            ++res;
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (willConflict(row, i, n)) {
                continue;
            }
            setPosition(row, i, n, true);
            dfs(row + 1, n);
            setPosition(row, i, n, false);
        }
    }

    private boolean willConflict(int row, int col, int n) {
        return column[col] || l2r[col - row + n - 1] || r2l[row + col];
    }

    private void setPosition(int row, int col, int n, boolean bool) {
        column[col] = bool;
        l2r[col - row + n - 1] = bool;
        r2l[row + col] = bool;
        board[row][col] = bool;
    }
}
// @lc code=end
