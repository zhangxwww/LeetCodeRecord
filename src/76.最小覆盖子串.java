import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    private int[] tMap = new int[128];
    private int[] windowMap = new int[128];

    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if (tlen == 0) {
            return "";
        }

        char[] tc = t.toCharArray();
        for (char tcc : tc) {
            ++tMap[tcc];
        }

        int keyCount = 0;
        int[] sMap = new int[128];
        for (int i = 0; i < slen; ++i) {
            char c = s.charAt(i);
            if (isKeyChar(c)) {
                ++keyCount;
                ++sMap[c];
            }
        }

        if (keyCount < tlen) {
            return "";
        }
        for (int i = 0; i < 128; ++i) {
            if (sMap[i] < tMap[i]) {
                return "";
            }
        }

        int minLen = 0x7fffffff;
        String minLenString = "";

        Queue<Integer> window = new LinkedList<>();
        int lastKeyIndex = -1;

        for (int i = lastKeyIndex + 1; i < slen; ++i) {
            if (isKeyChar(s.charAt(i))) {
                lastKeyIndex = i;
                break;
            }
        }
        window.offer(lastKeyIndex);
        ++windowMap[s.charAt(lastKeyIndex)];

        while (true) {
            if (match()) {
                int firstKeyIndex = window.peek();
                int len = lastKeyIndex - firstKeyIndex + 1;
                if (len < minLen) {
                    minLen = len;
                    minLenString = s.substring(firstKeyIndex, lastKeyIndex + 1);
                    if (minLen == tlen) {
                        break;
                    }
                }
                int popIndex = window.poll();
                --windowMap[s.charAt(popIndex)];
            } else {
                boolean nextFound = false;
                for (int i = lastKeyIndex + 1; i < slen; ++i) {
                    if (isKeyChar(s.charAt(i))) {
                        lastKeyIndex = i;
                        nextFound = true;
                        break;
                    }
                }
                if (!nextFound) {
                    break;
                }
                window.offer(lastKeyIndex);
                ++windowMap[s.charAt(lastKeyIndex)];
            }
        }
        return minLenString;
    }

    private boolean isKeyChar(char c) {
        return tMap[c] != 0;
    }

    private boolean match() {
        for (int i = 0; i < 128; ++i) {
            if (windowMap[i] < tMap[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
