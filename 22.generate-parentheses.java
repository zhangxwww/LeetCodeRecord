import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        res.add("");
        for (int i = 0; i < n; ++i) {
            Set<String> next = new HashSet<>();
            for (String s : res) {
                int len = s.length();
                for (int j = 0; j < len; ++j) {
                    if (s.charAt(j) == '(') {
                        next.add(s.substring(0, j + 1) + "()" + s.substring(j + 1));
                    }
                }
                next.add("()" + s);
            }
            res = next;
        }
        return new ArrayList<>(res);
    }
}
