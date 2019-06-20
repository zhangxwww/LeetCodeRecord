/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.52%)
 * Total Accepted:    399.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int len = haystack.length();
        int nlen = needle.length();
        int[] next = new int[nlen + 2];
        int j = 0;
        next[0] = -1;
        for (int i = 1; i < nlen + 2; i++) {
            next[i] = 0;
        }
        int k = -1;
        while (j < nlen) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        
        if (nlen > len) {
            return -1;
        }
        int i = 0;
        j = 0;
        while (i < len && j < nlen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= nlen) {
            return i - nlen;
        } else {
            return -1;
        }
    }
}
