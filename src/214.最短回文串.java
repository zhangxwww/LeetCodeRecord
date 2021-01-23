/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();

        int[] next = new int[len + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < len) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        i = 0;
        j = 0;
        while (i < len && j < len) {
            if (j == -1 || s.charAt(len - 1 - i) == s.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        int offset = i - j;
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < offset; i++) {
            sb.append(s.charAt(len - i - 1));
        }
        sb.append(s);
        return sb.toString();
    }
}
// @lc code=end
