import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    private List<Integer> res = new ArrayList<>();
    private Map<Integer, Boolean> used = new HashMap<>();

    public List<Integer> grayCode(int n) {
        res.add(0);
        if (n == 0) {
            return res;
        }
        used.put(0, true);
        int[] code = new int[n];
        for (int i = 0; i < n; ++i) {
            if (dfs(code, i, n)) {
                break;
            }
        }
        return res;
    }

    private boolean dfs(int[] code, int i, int n) {
        if (res.size() == (1 << n)) {
            return true;
        }
        code[i] = code[i] == 0 ? 1 : 0;
        int c = toInt(code);
        boolean found = false;
        if (used.containsKey(c) && used.get(c)) {

        } else { // don't used
            used.put(c, true);
            res.add(c);
            for (int j = 0; j < n; ++j) {
                if (dfs(code, j, n)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.remove(res.size() - 1);
            }
            used.put(c, false);
        }
        code[i] = code[i] == 0 ? 1 : 0;
        return found;
    }

    private int toInt(int[] code) {
        int res = 0;
        for (int i : code) {
            res = res * 2 + i;
        }
        return res;
    }
}
// @lc code=end
