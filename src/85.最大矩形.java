import java.util.Stack;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] continuousOneInEachRow = new int[n + 1][m];
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    continuousOneInEachRow[i][j] = ++count;
                } else {
                    count = 0;
                }
            }
        }

        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int col = 0; col < m; ++col) {
            s.clear();
            for (int row = 0; row < n + 1; ++row) {
                while (!s.empty() && continuousOneInEachRow[row][col] < continuousOneInEachRow[s.peek()][col]) {
                    int pos = s.peek();
                    s.pop();
                    int h = continuousOneInEachRow[pos][col];
                    if (h != 0) {
                        int area = h * (s.empty() ? row : row - s.peek() - 1);
                        maxArea = (area > maxArea) ? area : maxArea;
                    }
                }
                s.push(row);
            }
        }
        return maxArea;
    }
}
// @lc code=end
