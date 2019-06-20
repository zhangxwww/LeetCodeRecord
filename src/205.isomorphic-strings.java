
/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (36.92%)
 * Total Accepted:    195.6K
 * Total Submissions: 528.3K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the sames
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the sames length.
 * 
 */
import java.util.Vector;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int len = s.length();
        if (len == 1) {
            return true;
        }
        int[] inS = new int[256];
        int[] inT = new int[256];
        int diffInS = 0;
        int diffInT = 0;
        for (int i = 0; i < 256; i++) {
            inS[i] = -1;
            inT[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if ((inS[ss] != -1) ^ (inT[tt] != -1)) {
                return false;
            }
            if (inS[ss] == -1) {
                inS[ss] = diffInS++;
            }
            if (inT[tt] == -1) {
                inT[tt] = diffInT++;
            }
            if (inS[ss] != inT[tt]) {
                return false;
            }
        }
        return true;
    }
}
