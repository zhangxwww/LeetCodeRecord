/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */
class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = l1 + l2;
        int[] n1 = new int[l];
        int[] n2 = new int[l];
        for (int i = 0;; ++i) {
            if (i < l1) {
                n1[l1 - i - 1] = num1.charAt(i) - '0';
            }
            if (i < l2) {
                n2[l2 - i - 1] = num2.charAt(i) - '0';
            }
            if (i >= l1 && i >= l2) {
                break;
            }
        }
        int[] res = new int[l + 1];
        int highest = 0;
        for (int digit = 0; digit < l; ++digit) {
            int tmp = 0;
            for (int i = 0; i < digit + 1; ++i) {
                tmp += n1[i] * n2[digit - i];
            }
            if (tmp != 0) {
                highest = digit;
            }
            res[digit] = tmp;
        }
        for (int digit = 0; digit < l; ++digit) {
            int tmp = res[digit];
            res[digit] = tmp % 10;
            res[digit + 1] += tmp / 10;
            if (res[digit + 1] % 10 != 0) {
                highest = digit + 1;
            }
        }
        StringBuffer sb = new StringBuffer();
        while (highest >= 0) {
            sb.append(res[highest]);
            --highest;
        }
        String r = sb.toString();
        if (r == "") {
            return "0";
        } else {
            return r;
        }
    }
}
