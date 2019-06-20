/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                ++count[c - 'A' + 26];
            } else {
                ++count[c - 'a'];
            }
        }
        boolean hasEven = false;
        int longest = 0;
        for (int i = 0; i < 52; ++i) {
            if (count[i] % 2 == 0) {
                longest += count[i];
            } else {
                longest += count[i] - 1;
                hasEven = true;
            }
        }
        if (hasEven) {
            ++longest;
        }
        return longest;
    }
}
