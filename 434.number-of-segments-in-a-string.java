/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */
class Solution {
    public int countSegments(String s) {
        int n = s.length();
        boolean isSpace = true;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != ' ') {
                if (isSpace) {
                    isSpace = false;
                    ++count;
                }
            } else {
                isSpace = true;
            }
        }
        return count;
    }
}
