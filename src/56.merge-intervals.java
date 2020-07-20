/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return intervals;
        }
        sort(intervals, 0, n - 1);
        int m = 0;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] <= intervals[m][1]) {
                if (intervals[m][1] < intervals[i][1]) {
                    intervals[m][1] = intervals[i][1];
                }
            } else {
                ++m;
                intervals[m][0] = intervals[i][0];
                intervals[m][1] = intervals[i][1];
            }
        }
        int[][] res = new int[m + 1][2];
        System.arraycopy(intervals, 0, res, 0, m + 1);
        return res;
    }

    private void sort(int[][] a, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = left;
        int j = right;
        int[] x = a[i];
        while (i < j) {
            while (i < j && a[j][0] >= x[0]) {
                --j;
            }
            a[i] = a[j];
            while (i < j && a[i][0] <= x[0]) {
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = x;
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }
}
// @lc code=end
