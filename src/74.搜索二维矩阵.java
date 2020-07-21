/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int lower = 0;
        int upper = n * m - 1;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end
