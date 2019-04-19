import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.84%)
 * Total Accepted:    372.1K
 * Total Submissions: 905.4K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        char[][] map = new char[][] { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
        int len = digits.length();
        char[] str = digits.toCharArray();
        int[] d = new int[len];
        int alen = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == '1') {
                continue;
            }
            d[i] = str[i] - '1';
            alen++;
        }
        char[] path = new char[alen];
        List<String> res = new ArrayList<>();
        find(map, path, d, 0, res);
        return res;
    }

    private void find(char[][] map, char[] path, int[] d, int depth, List<String> res) {
        if (path.length == depth) {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        int count = map[d[depth]].length;
        for (int i = 0; i < count; i++) {
            path[depth] = map[d[depth]][i];
            find(map, path, d, depth + 1, res);
        }
    }
}
