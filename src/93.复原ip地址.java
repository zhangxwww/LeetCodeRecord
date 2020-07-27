import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    String[] path = new String[4];

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len >= 4 && len <= 12) {
            dfs(0, 0, s);
        }
        return res;
    }

    private void dfs(int start, int level, String s) {
        if (level == 4) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 4; ++i) {
                sb.append(path[i]);
                if (i != 3) {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
            return;
        }
        int len = s.length();
        if (level < 3) {
            for (int l = 1; l <= 3; ++l) {
                if (start + l + 3 - level > len) {
                    break;
                } else if (len - start - l > 9 - 3 * level) {
                    continue;
                }
                String ss = s.substring(start, start + l);
                if (valid(ss)) {
                    path[level] = ss;
                    dfs(start + l, level + 1, s);
                }
            }
        } else {
            String ss = s.substring(start);
            if (valid(ss)) {
                path[level] = ss;
                dfs(len, level + 1, s);
            }
        }
    }

    private boolean valid(String s) {
        int len = s.length();
        if (len == 0 || len > 3) {
            return false;
        }
        char c0 = s.charAt(0);
        if (len > 1 && c0 == '0') {
            return false;
        }
        if (len == 3) {
            if (c0 > '2') {
                return false;
            } else if (c0 == '2') {
                char c1 = s.charAt(1);
                if (c1 > '5') {
                    return false;
                } else if (c1 == '5') {
                    char c2 = s.charAt(2);
                    if (c2 > '5') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
