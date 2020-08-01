import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] last = new int[n];
        int[] cur = new int[n];
        last[0] = triangle.get(0).get(0);
        int minLength = last[0];
        for (int i = 1; i < n; ++i) {
            minLength = 0x7fffffff;
            List<Integer> curLine = triangle.get(i);
            cur[0] = last[0] + curLine.get(0);
            cur[i] = last[i - 1] + curLine.get(i);
            for (int j = 1; j < i; ++j) {
                cur[j] = min(last[j - 1], last[j]) + curLine.get(j);
                if (i == n - 1 && cur[j] < minLength) {
                    minLength = cur[j];
                }
            }
            if (i == n - 1) {
                minLength = min(minLength, cur[0]);
                minLength = min(minLength, cur[i]);
            }
            System.arraycopy(cur, 0, last, 0, i + 1);
        }
        return minLength;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }
}
// @lc code=end
