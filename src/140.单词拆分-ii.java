import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    private HashSet<String> set;
    private HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) {
            return new ArrayList<>();
        }
        set = new HashSet<>(wordDict);

        List<String> lenString = new ArrayList<>();
        lenString.add("");
        map.put(len, lenString);
        return dfs(s, 0, len);
    }

    private List<String> dfs(String s, int start, int len) {
        if (!map.containsKey(start)) {
            List<String> res = new ArrayList<>();
            for (int end = start + 1; end <= len; ++end) {
                String ss = s.substring(start, end);
                if (set.contains(ss)) {
                    List<String> r = dfs(s, end, len);
                    for (String sss : r) {
                        if (sss.length() > 0) {
                            res.add(ss + " " + sss);
                        } else {
                            res.add(ss);
                        }
                    }
                }
            }
            map.put(start, res);
        }
        return map.get(start);
    }
}
// @lc code=end
