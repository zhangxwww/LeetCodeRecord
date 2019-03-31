/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.88%)
 * Total Accepted:    367.5K
 * Total Submissions: 899.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean allNine = true;
        for (int i : digits) {
            if (i != 9) {
                allNine = false;
                break;
            }
        }
        int[] res;
        if (allNine) {
            res = new int[len + 1];
            for (int i = 1; i < len + 1; i++) {
                res[i] = 0;
            }
            res[0] = 1;
            return res;
        } else {
            boolean carry = true;
            int pos = len - 1;
            while (carry) {
                digits[pos]++;
                if (digits[pos] > 9) {
                    digits[pos] -= 10;
                    pos--;
                } else {
                    carry = false;
                }
            }
        }
        return digits;
    }
}
