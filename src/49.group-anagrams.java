
/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            char[] s = str.toCharArray();
            for (char c : s) {
                ++count[c - 'a'];
            }
            StringBuffer sb = new StringBuffer();
            for (int i : count) {
                sb.append(i + " ");
            }
            String hashStr = sb.toString();
            if (hash.containsKey(hashStr)) {
                hash.get(hashStr).add(str);
            } else {
                List<String> t = new ArrayList<>();
                t.add(str);
                hash.put(hashStr, t);
            }
        }
        for (List<String> v : hash.values()) {
            res.add(v);
        }
        return res;
    }
}
