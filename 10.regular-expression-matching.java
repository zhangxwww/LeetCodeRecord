/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.07%)
 * Total Accepted:    289.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();
        int ls = str.length;
        int lp = pat.length;
        if (lp == 0 && ls == 0) {
            return true;
        }
        if (ls == 1 && lp == 1) {
            return match(str[0], pat[0]);
        }
        if (p.equals(".*")) {
            return true;
        }
        char[] np = new char[lp];
        boolean[] star = new boolean[lp];
        int pcount = 0;
        for (int i = 0; i < lp; i++) {
            if (pat[i] == '*') {
                star[pcount - 1] = true;
            } else {
                np[pcount++] = pat[i];
            }
        }
        boolean allStar = true;
        for (int i = 0; i < pcount; i++) {
            if (!star[i]) {
                allStar = false;
            }
        }
        if (allStar && ls == 0) {
            return true;
        }
        boolean[][] d = new boolean[pcount + 1][ls + 1];
        for (int i = 0; i < pcount + 1; i++) {
            for (int j = 0; j < ls + 1; j++) {
                d[i][j] = false;
            }
        }
        d[0][0] = true;
        for (int i = 0; i < pcount; i++) {
            for (int j = 0; j < ls; j++) {
                if (match(str[j], np[i])) {
                    if (d[i][j] || (star[i] && d[i + 1][j])) {
                        d[i + 1][j + 1] = true;
                    } else {
                        for (int k = i; k > 0; k--) {
                            if (star[k - 1] && !d[k - 1][j]) {
                                continue;
                            } else if (star[k - 1] && d[k - 1][j]) {
                                d[i + 1][j + 1] = true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        boolean m = false;
        for (int k = pcount; k > 0; k--) {
            if (star[k - 1]) {
                if (d[k - 1][ls]) {
                    m = true;
                    break;
                }
            } else {
                break;
            }
        }
        return m || d[pcount][ls];
        /*
         * char[] np = new char[lp]; int[] count = new int[lp]; int nplen = 1; np[0] =
         * pat[0]; count[0] = 1; boolean[] changeable = new boolean[lp]; changeable[0] =
         * false; for (int i = 1; i < lp; i++) { changeable[i] = false; if (pat[i] ==
         * '*') { count[nplen - 1]--; changeable[nplen - 1] = true; } else if (pat[i] ==
         * np[nplen - 1]) { count[nplen - 1]++; } else { np[nplen++] = pat[i]; } }
         */
        /*
         * char[] ns = new char[ls]; int[] scount = new int[ls]; int nslen = 1; ns[0] =
         * str[0]; scount[0] = 1; for (int i = 1; i < ls; i++) { if (str[i] == ns[nslen
         * - 1]) { scount[nslen - 1]++; } else { ns[nslen++] = str[i]; } } int i = 0;
         * int j = 0; for (; i < nslen && j < nplen;) { if (changeable[j]) { if
         * (count[j] == 0) { if (match(ns[i], np[j])) { i++; j++; } else { j++; } } else
         * { if (match(ns[i], np[j]) && scount[i] >= count[j]) { i++; j++; } else {
         * return false; } } } else { if (match(ns[i], np[j]) && scount[i] == count[j])
         * { i++; j++; } else { return false; } } } return (i == nslen) && (j == nplen);
         */
    }

    private boolean match(char s, char p) {
        return (p == '.' || (s == p));
    }
}
