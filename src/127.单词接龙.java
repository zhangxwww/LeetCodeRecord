import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> wordq = new LinkedList<>();
        Queue<Integer> lenq = new LinkedList<>();
        HashSet<String> used = new HashSet<>();

        used.add(beginWord);
        wordq.offer(beginWord);
        lenq.offer(1);

        while (!wordq.isEmpty()) {
            String word = wordq.poll();
            int len = lenq.poll();
            for (String next : wordList) {
                if (!used.contains(next)) {
                    if (validChange(word, next)) {
                        if (next.equals(endWord)) {
                            return len + 1;
                        }
                        wordq.offer(next);
                        lenq.offer(len + 1);
                        used.add(next);
                    }
                }
            }
        }
        return 0;
    }

    private boolean validChange(String from, String to) {
        int n = from.length();
        if (from.equals(to)) {
            return false;
        }
        boolean diff = false;
        for (int i = 0; i < n; ++i) {
            if (from.charAt(i) != to.charAt(i)) {
                if (diff) {
                    return false;
                }
                diff = true;
            }
        }
        return true;
    }
}
// @lc code=end
