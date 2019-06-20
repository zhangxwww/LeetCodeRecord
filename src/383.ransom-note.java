/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int l1 = ransomNote.length();
        int l2 = magazine.length();
        for (int i = 0; i < l2; ++i) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < l1; ++i) {
            int pos = ransomNote.charAt(i) - 'a';
            count[pos]--;
            if (count[pos] < 0) {
                return false;
            }
        }
        return true;
    }
}
