/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.20%)
 * Total Accepted:    254.1K
 * Total Submissions: 789.4K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int count = 0;
        boolean start = false;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                start = true;
            } else {
                if (start) {
                    break;
                }
            }
        }
        return count;
    }
}
