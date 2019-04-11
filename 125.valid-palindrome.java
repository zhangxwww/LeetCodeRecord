/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.53%)
 * Total Accepted:    338.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int len = s.length();
        if (len == 1) {
            return true;
        }
        int start = 0;
        int end = -1;
        char[] str = s.toLowerCase().toCharArray();
        char[] ns = new char[len];
        for (char c : str) {
            if (inAlphabet(c)) {
                ns[++end] = c;
            }
        }
        if (end <= 0) {
            return true;
        }
        while (start < end + 1) {
            if (ns[start] != ns[end]) {
                return false;
            }
            ++start;
            --end;

        }
        return true;
    }

    private boolean inAlphabet(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}
