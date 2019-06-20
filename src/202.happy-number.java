
/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (44.57%)
 * Total Accepted:    223.3K
 * Total Submissions: 499.2K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 */
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return h(n, set);
    }

    private boolean h(int n, HashSet<Integer> set) {
        if (n == 1) {
            return true;
        }
        int x = 0;
        while (n > 0) {
            int b = n % 10;
            x += b * b;
            n /= 10;
        }
        if (set.contains(x)) {
            return false;
        } else {
            set.add(x);
            return h(x, set);
        }
    }
}
