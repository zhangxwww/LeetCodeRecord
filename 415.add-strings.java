/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int l = ((l1 > l2) ? l1 : l2) + 1;
        char[] s = new char[l];
        s[0] = '0';
        boolean c = false;
        while (l1 > 0 && l2 > 0) {
            int ss = s1[l1 - 1] + s2[l2 - 1] - 2 * '0' + (c ? 1 : 0);
            c = false;
            if (ss > 9) {
                ss -= 10;
                c = true;
            }
            s[l - 1] = (char) (ss + '0');
            --l1;
            --l2;
            --l;
        }
        while (l1 > 0) {
            int ss = s1[l1 - 1] - '0' + (c ? 1 : 0);
            c = false;
            if (ss > 9) {
                ss -= 10;
                c = true;
            }
            s[l - 1] = (char) (ss + '0');
            --l1;
            --l;
        }
        while (l2 > 0) {
            int ss = s2[l2 - 1] - '0' + (c ? 1 : 0);
            c = false;
            if (ss > 9) {
                ss -= 10;
                c = true;
            }
            s[l - 1] = (char) (ss + '0');
            --l2;
            --l;
        }
        if (c) {
            s[0] = '1';
            return String.valueOf(s);
        } else {
            return String.valueOf(s, 1, s.length - 1);
        }
    }
}
