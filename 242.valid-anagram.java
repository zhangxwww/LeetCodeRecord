/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int ls = s.length();
        int lt = t.length();
        if (ls != lt) {
            return false;
        }
        for (int i = 0; i < ls; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lt; i++) {
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
