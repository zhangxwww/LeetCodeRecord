/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.87%)
 * Total Accepted:    512.2K
 * Total Submissions: 1.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[][] m = new boolean[len][len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            m[i][i] = true;
            if (i < len - 1) {
                if (str[i] == str[i + 1]) {
                    m[i][i + 1] = true;
                    max = 1;
                } else {
                    m[i][i + 1] = false;
                }
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; i + j < len; j++) {
                if (m[j + 1][i + j - 1] && str[j] == str[i + j]) {
                    m[j][i + j] = true;
                    max = i;
                }
            }
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i + max < len; i++) {
            if (m[i][i + max]) {
                start = i;
                end = i + max;
                break;
            }
        }
        return s.substring(start, end + 1);
    }
}
