/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        return longPow(x, (long) n);
    }

    private double longPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1.0 / x;
            n *= -1;
        }
        long half = n / 2;
        double halfRes = longPow(x, half);
        double res = halfRes * halfRes;
        if (n % 2 == 1) {
            res *= x;
        }
        return res;
    }
}
