/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.17%)
 * Total Accepted:    430.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder("");
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        int sLen = strs[0].length();
        boolean tooLong = false;
        boolean same = true;
        for (int i = 0; i < sLen && !tooLong && same; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (strs[j].length() <= i) {
                    tooLong = true;
                    same = false;
                    break;
                }
                if (strs[j].charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            if (same) {
                s.append(c);
            }
        }
        return s.toString();
    }
}
