import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, String> map = new HashMap<>();
        int a = 0;
        int n = s.length();
        Set<Integer> dup = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (n <= 10) {
            return res;
        }
        for (int i = 0; i < 9; i++) {
            a = update(a, s.charAt(i));
        }
        for (int i = 9; i < n; i++) {
            a = update(a, s.charAt(i));
            if (map.keySet().contains(a)) {
                dup.add(a);
            } else {
                map.put(a, s.substring(i - 9, i + 1));
            }
        }
        for (int d : dup) {
            res.add(map.get(d));
        }
        return res;
    }

    int update(int a, char c) {
        return ((a << 2) & 0xFFFFC) + toInt(c);
    }

    int toInt(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 0;
    }
}
// @lc code=end
