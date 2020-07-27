/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int tmp = 0;
            for (int j = 0, k = i - 1; j < k; ++j, --k) {
                tmp += d[j] * d[k];
            }
            tmp *= 2;
            if (i % 2 == 1) {
                tmp += d[i / 2] * d[i / 2];
            }
            d[i] = tmp;
        }

        return d[n];
    }
}
// @lc code=end
