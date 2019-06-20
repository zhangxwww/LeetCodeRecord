/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */
class Solution {
    public int getSum(int a, int b) {
        int c = 0;
        int s = 0;
        for (int i = 0; i < 32; ++i) {
            int aa = a & (0x1 << i);
            int bb = b & (0x1 << i);
            s |= aa ^ bb ^ c;
            c = (aa & c) | (bb & c) | (aa & bb);
            c <<= 1;
        }
        return s;
    }
}
