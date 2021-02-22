import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return n;
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int ver = 1;
            int same = 0;
            Map<Integer[], Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i][0] != points[j][0]) {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int d = gcd(dx, dy);
                    if (d != 0) {
                        dx /= d;
                        dy /= d;
                    }
                    boolean found = false;
                    for (Integer[] a : map.keySet()) {
                        if (a[0] == dx && a[1] == dy) {
                            found = true;
                            int c = map.get(a);
                            map.put(a, c + 1);
                            if (c + 1 > count) {
                                count = c + 1;
                            }
                        }
                    }
                    if (!found) {
                        map.put(new Integer[] { dx, dy }, 2);
                        if (count < 2) {
                            count = 2;
                        }
                    }
                } else {
                    if (points[i][1] == points[j][1]) {
                        same++;
                    }
                    ver++;
                }
            }
            count += same;
            count = Math.max(count, ver);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
// @lc code=end
