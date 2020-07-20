/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    int direction = 0;
    int[] nextDirection = new int[] { 1, 2, 3, 0 };
    int top, down, left, right;
    int row, col;
    int[] rowStep = new int[] { 0, 1, 0, -1 };
    int[] colStep = new int[] { 1, 0, -1, 0 };

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int n2 = n * n;
        top = 0;
        down = n;
        left = 0;
        right = n;
        row = 0;
        col = 0;
        for (int k = 0; k < n2; ++k) {
            matrix[row][col] = k + 1;
            if (shouldTurn()) {
                turn();
            }
            nextPosition();
        }
        return matrix;
    }

    private boolean shouldTurn() {
        if (direction == 0 && col == right - 1) {
            return true;
        } else if (direction == 1 && row == down - 1) {
            return true;
        } else if (direction == 2 && col == left) {
            return true;
        } else if (direction == 3 && row == top) {
            return true;
        } else {
            return false;
        }
    }

    private void turn() {
        switch (direction) {
        case 0:
            ++top;
            break;
        case 1:
            --right;
            break;
        case 2:
            --down;
            break;
        case 3:
            ++left;
            break;
        }
        direction = nextDirection[direction];
    }

    private void nextPosition() {
        row += rowStep[direction];
        col += colStep[direction];
    }
}
// @lc code=end
