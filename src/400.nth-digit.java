/*
 * @lc app=leetcode id=400 lang=java
 *
 * [400] Nth Digit
 */
class Solution {
    public int findNthDigit(int n) {
        int[] start = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };
        int[] count = new int[] { 0, 9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889 };
        for (int i = 9; i >= 1; --i) {
            if (n > count[i - 1]) {
                n -= count[i - 1];
                int num = start[i - 1] + (n - 1) / i;
                int d = (i - n % i) % i;
                while (d > 0) {
                    num /= 10;
                    --d;
                }
                return num % 10;
            }
        }
        return n;
    }
}
