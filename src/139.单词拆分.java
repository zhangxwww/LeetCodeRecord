import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        if (len == 0) {
            return true;
        }
        boolean[] d = new boolean[len + 1];
        d[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (d[j] && set.contains(s.substring(j, i))) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[len];
    }
}
// @lc code=end
