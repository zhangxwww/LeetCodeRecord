/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] row = new boolean[81];
        boolean[] col = new boolean[81];
        boolean[] block = new boolean[81];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                } else {
                    int n = c - '1';
                    if (row[i * 9 + n] || col[j * 9 + n] || block[((i / 3) * 3 + j / 3) * 9 + n]) {
                        return false;
                    }
                    row[i * 9 + n] = true;
                    col[j * 9 + n] = true;
                    block[((i / 3) * 3 + j / 3) * 9 + n] = true;
                }
            }
        }
        return true;
    }
}
