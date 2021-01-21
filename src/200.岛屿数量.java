import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    private class Cell {
        int i, j;

        Cell(int ii, int jj) {
            i = ii;
            j = jj;
        }
    }

    public int numIslands(char[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    q.offer(new Cell(i, j));
                    grid[i][j] = '0';
                    while (q.size() > 0) {
                        Cell c = q.poll();
                        if (c.i < n - 1 && grid[c.i + 1][c.j] == '1') {
                            q.offer(new Cell(c.i + 1, c.j));
                            grid[c.i + 1][c.j] = '0';
                        }
                        if (c.i > 0 && grid[c.i - 1][c.j] == '1') {
                            q.offer(new Cell(c.i - 1, c.j));
                            grid[c.i - 1][c.j] = '0';
                        }
                        if (c.j < m - 1 && grid[c.i][c.j + 1] == '1') {
                            q.offer(new Cell(c.i, c.j + 1));
                            grid[c.i][c.j + 1] = '0';
                        }
                        if (c.j > 0 && grid[c.i][c.j - 1] == '1') {
                            q.offer(new Cell(c.i, c.j - 1));
                            grid[c.i][c.j - 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
