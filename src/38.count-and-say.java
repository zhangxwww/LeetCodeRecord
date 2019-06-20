/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.87%)
 * Total Accepted:    267.8K
 * Total Submissions: 671.6K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }
        for (; n > 1; n--) {
            StringBuilder sb = new StringBuilder("");
            int len = res.length();
            for (int i = 0; i < len;) {
                char c = res.charAt(i);
                int count = 1;
                for (int j = 1; j + i < len; j++) {
                    if (res.charAt(i + j) == c) {
                        count++;
                    } else {
                        break;
                    }
                }
                sb.append("" + count);
                sb.append(c);
                i += count;
            }
            res = sb.toString();
        }
        return res;
    }
}
