import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    int direction = 0;
    int[] nextDirection = new int[] { 1, 2, 3, 0 };
    int top, down, left, right;
    int row, col;
    int[] rowStep = new int[] { 0, 1, 0, -1 };
    int[] colStep = new int[] { 1, 0, -1, 0 };

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        int m = matrix[0].length;
        int nm = n * m;
        top = 0;
        down = n;
        left = 0;
        right = m;
        row = 0;
        col = 0;
        int[] res = new int[nm];
        for (int k = 0; k < nm; ++k) {
            res[k] = matrix[row][col];
            if (shouldTurn()) {
                turn();
            }
            nextPosition();
        }
        List<Integer> rres = new ArrayList<>(nm);
        for (int x : res) {
            rres.add(x);
        }
        return rres;
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
