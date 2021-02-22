import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        List<String> ss = new ArrayList<>();
        for (int i : nums) {
            ss.add(String.valueOf(i));
        }
        Collections.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.equals(s2)) {
                    return 0;
                }
                int l1 = s1.length();
                int l2 = s2.length();
                int ls = Math.min(l1, l2);

                int com = l1 < l2 ? -1 : 1;
                String sht = l1 < l2 ? s1 : s2;
                String lng = l1 < l2 ? s2 : s1;
                while (lng.startsWith(sht)) {
                    lng = lng.substring(ls);
                }
                int lr = lng.length();
                int l = Math.min(lr, ls);

                if (l == 0) {
                    return 0;
                }

                for (int i = 0; i < l; i++) {
                    if (sht.charAt(i) < lng.charAt(i)) {
                        return -com;
                    } else if (sht.charAt(i) > lng.charAt(i)) {
                        return com;
                    }
                }
                if (lr > ls) {
                    return sht.charAt(0) < lng.charAt(l) ? com : -com;
                } else {
                    return sht.charAt(l) < lng.charAt(0) ? -com : com;
                }
            }
        });
        StringBuffer sb = new StringBuffer();
        boolean found = false;
        for (String s : ss) {
            if (!found && s.equals("0")) {
                continue;
            }
            if (!found && !s.equals("0")) {
                found = true;
            }
            sb.append(s);
        }
        String res = sb.toString();
        return res.length() == 0 ? "0" : res;
    }
}
// @lc code=end
