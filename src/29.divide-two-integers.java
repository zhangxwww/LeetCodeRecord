/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return 0x7fffffff;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean neg = (dividend > 0 ^ divisor > 0);
        long a = (dividend > 0) ? dividend : (-(long) dividend);
        long b = (divisor > 0) ? divisor : (-(long) divisor);
        long up = a;
        long down = 1;
        long r = 0;
        while (down <= up) {
            long m = (up + down) / 2;
            if (m * b > a) {
                up = m - 1;
            } else if ((m + 1) * b <= a) {
                down = m + 1;
            } else {
                r = m;
                break;
            }
        }
        if (neg) {
            r = -r;
        }
        if ((int) r == r) {
            return (int) r;
        } else {
            return 0x7fffffff;
        }
    }
}
