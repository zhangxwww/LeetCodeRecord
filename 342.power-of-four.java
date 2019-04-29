/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0 && num == (num & (-num)) && ((num & 0x55555555) == num));
    }
}
