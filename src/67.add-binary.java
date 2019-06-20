/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.37%)
 * Total Accepted:    287.2K
 * Total Submissions: 747.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binasry strings, return their sum (alo a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int l = (la > lb) ? la + 1 : lb + 1;
        int minl = (la < lb) ? la : lb;
        boolean carry = false;
        char[] res = new char[l];
        for (int i = 1; i <= minl; i++) {
            if ((a.charAt(la - i) == '1') ^ (b.charAt(lb - i) == '1') ^ carry) {
                res[l - i] = '1';
            } else {
                res[l - i] = '0';
            }
            if (((a.charAt(la - i) == '1') && (b.charAt(lb - i) == '1'))
                    || (carry && (a.charAt(la - i) == '1' ^ b.charAt(lb - i) == '1'))) {
                carry = true;
            } else {
                carry = false;
            }
        }
        for (int i = minl + 1; i <= la; i++) {
            if (carry && a.charAt(la - i) == '1') {
                carry = true;
                res[l - i] = '0';
            } else {
                if (carry ^ (a.charAt(la - i) == '1')) {
                    res[l - i] = '1';
                } else {
                    res[l - i] = '0';
                }
                carry = false;
            }
        }
        for (int i = minl + 1; i <= lb; i++) {
            if (carry && b.charAt(lb - i) == '1') {
                carry = true;
                res[l - i] = '0';
            } else {
                if (carry ^ (b.charAt(lb - i) == '1')) {
                    res[l - i] = '1';
                } else {
                    res[l - i] = '0';
                }
                carry = false;
            }
        }
        if (carry) {
            res[0] = '1';
        } else {
            res[0] = '0';
        }
        String r = String.valueOf(res);
        if (res[0] == '0') {
            return r.substring(1);
        }
        return r;
    }
}
