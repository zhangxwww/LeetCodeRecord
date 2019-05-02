/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num < 2) {
            return true;
        }
        int low = 2;
        int high = num / 2;
        high = high < 46340 ? high : 46340;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid < num) {
                low = mid + 1;
            } else if (mid * mid > num) {
                high = mid - 1;
            } else {
                return true;
            }

        }
        return low * low == num;
    }
}
