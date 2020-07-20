/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][] { newInterval };
        }
        int left = find(intervals, newInterval[0], 0);
        int right = find(intervals, newInterval[1], 1);
        boolean overLeft = !(left == -1 || intervals[left][1] < newInterval[0]);
        boolean overRight = !(right == n - 1 || intervals[right + 1][0] > newInterval[1]);
        if (overLeft) {
            newInterval[0] = intervals[left--][0];
        }
        if (overRight) {
            newInterval[1] = intervals[++right][1];
        }
        int newn = n - right + left + 1;
        int[][] res = new int[newn][2];
        System.arraycopy(intervals, 0, res, 0, left + 1);
        res[left + 1] = newInterval;
        System.arraycopy(intervals, right + 1, res, left + 2, n - right - 1);
        return res;
    }

    private int find(int[][] a, int t, int axis) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (a[m][axis] < t) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return start - 1;
    }
}
// @lc code=end
