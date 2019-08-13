/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int n = ss.length;
        int m = pp.length;
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (match[i - 1][j - 1]) {
                    if (pp[i - 1] == '*') {
                        for (int k = j - 1; k < n + 1; ++k) {
                            match[i][k] = true;
                        }
                        break;
                    } else {
                        if (isMatched(ss[j - 1], pp[i - 1])) {
                            match[i][j] = true;
                        }
                    }
                }
            }
            if (match[i - 1][n] && pp[i - 1] == '*') {
                match[i][n] = true;
            }
        }
        return match[m][n];
    }

    private boolean isMatched(char s, char p) {
        return s == p || p == '*' || p == '?';
    }
}
