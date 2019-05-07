/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        int[] count = new int[26];
        for (int i = 0; i < 26; ++i) {
            count[i] = -2;
        }
        for (int i = len - 1; i >= 0; --i) {
            int pos = s.charAt(i) - 'a';
            if (count[pos] > 0) {
                count[pos] = -1;
            } else if (count[pos] == -2) {
                count[pos] = i;
            }
        }
        int index = -1;
        for (int i : count) {
            if (i >= 0 && ((i < index) || (index < 0))) {
                index = i;
            }
        }
        return index;
    }
}
