
/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length();
        int n = words.length;
        if (len == 0 || n == 0) {
            return new ArrayList<>();
        }
        int wl = words[0].length();
        if (wl > len) {
            return new ArrayList<>();
        }
        int q = 1000003;
        int d = 26;
        int h = calH(wl, d, q);
        Map<Integer, List<String>> map = preprocess(words, q, wl, d);
        Map<String, Integer> wordIndex = getWordIndexMap(words);

        int[] aim = eachCount(words, wordIndex);
        int aimCount = wordIndex.size();

        int[] t = new int[len - wl + 1];
        int[] indexList = new int[len - wl + 1];
        t[0] = calT0(s, q, wl, d);
        for (int ss = 0; ss < len - wl + 1; ++ss) {
            List<String> l = map.get(t[ss]);
            if (l != null) {
                for (String sss : l) {
                    if (sss.equals(s.substring(ss, ss + wl))) {
                        int index = wordIndex.get(sss);
                        indexList[ss] = index;
                        break;
                    }
                    indexList[ss] = -1;
                }
            } else {
                indexList[ss] = -1;
            }
            if (ss < len - wl) {
                t[ss + 1] = (int) (((long) d * ((long) t[ss] - (long) (s.charAt(ss) - 'a') * (long) h)
                        + (long) (s.charAt(ss + wl) - 'a')) % q);
                if (t[ss + 1] < 0) {
                    t[ss + 1] += q;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wl; ++i) {
            int realCount = 0;
            int[] real = new int[aimCount];
            int curCount = 0;
            for (int j = i; j < len - wl + 1; j += wl) {
                if (curCount == n) {
                    int leave = indexList[j - n * wl];
                    if (leave != -1) {
                        if (real[leave] == aim[leave]) {
                            --realCount;
                        }
                        --real[leave];
                        if (real[leave] == aim[leave]) {
                            ++realCount;
                        }
                    }
                } else {
                    ++curCount;
                }
                int next = indexList[j];
                if (next != -1) {
                    if (real[next] == aim[next]) {
                        --realCount;
                    }
                    ++real[next];
                    if (real[next] == aim[next]) {
                        ++realCount;
                        if (realCount == aimCount) {
                            res.add(j - (n - 1) * wl);
                        }
                    }
                }
            }
        }
        return res;
    }

    private Map<Integer, List<String>> preprocess(String[] words, int q, int m, int d) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : words) {
            int p = 0;
            for (int i = 0; i < m; ++i) {
                p = (int) (((long) d * (long) p + (long) (s.charAt(i) - 'a')) % q);
            }
            List<String> list = map.get(p);
            if (list == null) {
                list = new ArrayList<>();
                map.put(p, list);
            }
            list.add(s);
        }
        return map;
    }

    private Map<String, Integer> getWordIndexMap(String[] words) {
        Map<String, Integer> wordIndexMap = new HashMap<>();
        int i = 0;
        for (String s : words) {
            if (wordIndexMap.get(s) == null) {
                wordIndexMap.put(s, i);
                ++i;
            }
        }
        return wordIndexMap;
    }

    private int[] eachCount(String[] words, Map<String, Integer> wordIndexMap) {
        int[] c = new int[wordIndexMap.size()];
        for (String s : words) {
            int index = wordIndexMap.get(s);
            ++c[index];
        }
        return c;
    }

    private int calH(int m, int d, int q) {
        int k = 1;
        for (int i = 0; i < m - 1; ++i) {
            k = (int) (((long) k * (long) d) % q);
        }
        return k;
    }

    private int calT0(String s, int q, int m, int d) {
        int t = 0;
        for (int i = 0; i < m; ++i) {
            t = (int) (((long) d * (long) t + (long) (s.charAt(i) - 'a')) % q);
        }
        return t;
    }
}
