/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= len; ++i) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
