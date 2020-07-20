/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0) {
            return l2;
        } else if (l2 == 0) {
            return l1;
        }
        int[][] dis = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; ++i) {
            dis[i][0] = i;
        }
        for (int j = 1; j <= l2; ++j) {
            dis[0][j] = j;
        }
        for (int i = 0; i < l1; ++i) {
            for (int j = 0; j < l2; ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dis[i + 1][j + 1] = dis[i][j];
                } else {
                    dis[i + 1][j + 1] = minThree(dis[i][j + 1], dis[i + 1][j], dis[i][j]) + 1;
                }
            }
        }
        return dis[l1][l2];
    }

    private int minThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end
