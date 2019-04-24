/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
