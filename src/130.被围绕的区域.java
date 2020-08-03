import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        int[][] state = new int[n][m];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                qx.offer(i);
                qy.offer(0);
                state[i][0] = 1;
            }
            if (board[i][m - 1] == 'O') {
                qx.offer(i);
                qy.offer(m - 1);
                state[i][m - 1] = 1;
            }
        }
        for (int j = 1; j < m - 1; ++j) {
            if (board[0][j] == 'O') {
                qx.offer(0);
                qy.offer(j);
                state[0][j] = 1;
            }
            if (board[n - 1][j] == 'O') {
                qx.offer(n - 1);
                qy.offer(j);
                state[n - 1][j] = 1;
            }
        }
        while (!qx.isEmpty() && !qy.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            state[x][y] = 2;
            if (x > 0 && state[x - 1][y] == 0 && board[x - 1][y] == 'O') {
                qx.offer(x - 1);
                qy.offer(y);
                state[x - 1][y] = 1;
            }
            if (x < n - 1 && state[x + 1][y] == 0 && board[x + 1][y] == 'O') {
                qx.offer(x + 1);
                qy.offer(y);
                state[x + 1][y] = 1;
            }
            if (y > 0 && state[x][y - 1] == 0 && board[x][y - 1] == 'O') {
                qx.offer(x);
                qy.offer(y - 1);
                state[x][y - 1] = 1;
            }
            if (y < m - 1 && state[x][y + 1] == 0 && board[x][y + 1] == 'O') {
                qx.offer(x);
                qy.offer(y + 1);
                state[x][y + 1] = 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (state[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
// @lc code=end
