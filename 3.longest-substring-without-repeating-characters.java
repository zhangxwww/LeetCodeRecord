/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.12%)
 * Total Accepted:    855.1K
 * Total Submissions: 3M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[256];
        for (int i = 0; i < 256; i++) {
            hash[i] = false;
        }
        int max = 0;
        int count = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        for (int i = 0; i < len; i++) {
            char c = str[i];
            if (hash[c] == false) {
                count++;
                if (count > max) {
                    max = count;
                }
                hash[c] = true;
            } else {
                int cc = 1;
                boolean find = false;
                int pos = 0;
                for (; cc <= count; cc++) {
                    if (!find && str[i - cc] == c) {
                        find = true;
                        pos = cc;
                    } else if (find) {
                        hash[str[i - cc]] = false;
                    }
                }
                hash[c] = true;
                count = pos;
            }
        }
        return max;
    }
}
