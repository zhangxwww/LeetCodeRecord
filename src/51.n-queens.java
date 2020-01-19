import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    private boolean[][] board;
    private boolean[] column;
    private boolean[] l2r;
    private boolean[] r2l;

    public List<List<String>> solveNQueens(int n) {
        board = new boolean[n][n];
        column = new boolean[n];
        l2r = new boolean[2 * n - 1];
        r2l = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, int row, int n) {
        if (row == n) {
            res.add(draw(n));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (willConflict(row, i, n)) {
                continue;
            }
            setPosition(row, i, n, true);
            dfs(res, row + 1, n);
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

    private List<String> draw(int n) {
        List<String> res = new ArrayList<>();
        for (int row = 0; row < n; ++row) {
            char[] tmp = new char[n];
            for (int col = 0; col < n; ++col) {
                tmp[col] = board[row][col] ? 'Q' : '.';
            }
            res.add(String.valueOf(tmp));
        }
        return res;
    }
}
// @lc code=end
