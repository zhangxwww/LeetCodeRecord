/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int y = num;
        for (int i = 7; i >= 0; --i) {
            int x = y & 0xf;
            y >>= 4;
            if (x <= 9) {
                sb.append(x);
            } else {
                sb.append((char) ('a' + x - 10));
            }
        }
        int start = 0;
        if (num > 0 && num <= 0x10000000 - 1) {
            for (int i = 6; i >= 0; --i) {
                if ((num & (0xf << (i * 4))) != 0) {
                    start = 7 - i;
                    break;
                }
            }
        }
        return sb.reverse().substring(start).toString();
    }
}
