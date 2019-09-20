/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */
class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int l = 0; l < size - 1 - l; ++l) {
            rotate_ring(matrix, l, size - 1 - l);
        }
    }

    private void rotate_ring(int[][] m, int l, int r) {
        for (int i = l; i < r; ++i) {
            rotate_item(m, l, i);
        }
    }

    private void rotate_item(int[][] m, int i, int j) {
        int size = m.length;
        int tmp = m[i][j];
        m[i][j] = m[size - 1 - j][i];
        m[size - 1 - j][i] = m[size - 1 - i][size - 1 - j];
        m[size - 1 - i][size - 1 - j] = m[j][size - 1 - i];
        m[j][size - 1 - i] = tmp;
    }
}
