import java.util.regex.*;
/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        String r = "^\\s*[+-]?((\\d+(\\.\\d+)?)|(\\.\\d+)|(\\d+\\.))(e[+-]?\\d+)?\\s*$";
        return Pattern.matches(r, s);
    }
}
// @lc code=end
