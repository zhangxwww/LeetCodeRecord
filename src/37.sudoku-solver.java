
/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
import java.util.Vector;

class Solution {
    private Vector<Integer> cell;
    boolean[] row;
    boolean[] col;
    boolean[] block;

    public void solveSudoku(char[][] board) {
        cell = new Vector<>();
        row = new boolean[81];
        col = new boolean[81];
        block = new boolean[81];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    cell.add(i * 9 + j);
                } else {
                    int n = c - '1';
                    row[i * 9 + n] = true;
                    col[j * 9 + n] = true;
                    block[((i / 3) * 3 + j / 3) * 9 + n] = true;
                }
            }
        }
        int ncell = cell.size();
        if (ncell == 0) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            if (bt(board, 0, i, ncell)) {
                return;
            }
        }
    }

    private boolean bt(char[][] board, int depth, int newchar, int ncell) {
        if (depth == ncell) {
            return true;
        }
        int pos = cell.get(depth);
        if (valid(pos, newchar)) {
            add(board, pos, newchar);
            for (int i = 0; i < 9; ++i) {
                if (bt(board, depth + 1, i, ncell)) {
                    return true;
                }
            }
            remove(board, pos, newchar);
            return false;
        }
        return false;
    }

    private boolean valid(int pos, int newchar) {
        int i = pos / 9;
        int j = pos % 9;
        return !(row[i * 9 + newchar] || col[j * 9 + newchar] || block[((i / 3) * 3 + j / 3) * 9 + newchar]);
    }

    private void add(char[][] b, int pos, int c) {
        int i = pos / 9;
        int j = pos % 9;
        b[i][j] = (char) ('1' + c);
        row[i * 9 + c] = true;
        col[j * 9 + c] = true;
        block[((i / 3) * 3 + j / 3) * 9 + c] = true;
    }

    private void remove(char[][] b, int pos, int c) {
        int i = pos / 9;
        int j = pos % 9;
        b[i][j] = '.';
        row[i * 9 + c] = false;
        col[j * 9 + c] = false;
        block[((i / 3) * 3 + j / 3) * 9 + c] = false;
    }
}
