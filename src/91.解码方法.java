/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int lastD = 1;
        int lastC = 0;
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        char ai = s.charAt(0);
        char ai_1;
        for (int i = 1; i < n; ++i) {
            ai_1 = ai;
            ai = s.charAt(i);
            int d;
            int c;
            if (ai == '0' && (ai_1 == '1' || ai_1 == '2')) {
                d = lastD - lastC;
                c = d;
            } else if (match(ai_1, ai)) {
                d = 2 * lastD - lastC;
                c = lastD - lastC;
            } else if (ai == '0' && ai_1 != '1' && ai_1 != '2') {
                return 0;
            } else {
                d = lastD;
                c = 0;
            }
            lastD = d;
            lastC = c;
        }
        return lastD;
    }

    private boolean match(char ci_1, char ci) {
        return ci_1 == '1' || (ci_1 == '2' && '0' <= ci && ci <= '6');
    }
}
// @lc code=end
