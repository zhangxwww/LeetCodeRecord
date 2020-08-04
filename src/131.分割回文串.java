import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private Stack<String> path = new Stack<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        int len = s.length();
        if (start == len) {
            res.add(new ArrayList<>(path));
        }
        for (int end = start + 1; end <= len; ++end) {
            String ss = s.substring(start, end);
            if (palindrome(ss)) {
                path.push(ss);
                dfs(s, end);
                path.pop();
            }
        }
    }

    private boolean palindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
