/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] c = new int[n + 1];
        int max = 0;
        for (int i = n - 2; i >= 0; --i) {
            char cc = s.charAt(i);
            if (cc == '(') {
                char next = s.charAt(i + 1);
                if (next == '(') {
                    int d = c[i + 1] + i + 1;
                    if (d < n && s.charAt(d) == ')') {
                        c[i] = c[i + 1] + 2;
                        if (d < n) {
                            c[i] += c[d + 1];
                        }
                    }
                } else {
                    c[i] = 2 + c[i + 2];
                }
                if (c[i] > max) {
                    max = c[i];
                }
            }
        }
        return max;
    }
}
