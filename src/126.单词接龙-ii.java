import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        HashSet<String> used = new HashSet<>();
        HashSet<String> unused = new HashSet<>(wordList);

        List<State> currentStates = new ArrayList<>();
        List<State> nextStates = new ArrayList<>();
        nextStates.add(new State(beginWord, null));

        used.add(beginWord);

        boolean found = false;
        while (!found) {
            currentStates = nextStates;
            nextStates = new ArrayList<>();
            HashSet<String> needToBeRemoved = new HashSet<>();
            for (String next : unused) {
                if (!used.contains(next)) {
                    for (State s : currentStates) {
                        if (validChange(s.word, next)) {
                            nextStates.add(new State(next, s));
                            needToBeRemoved.add(next);
                        }
                    }
                }
            }
            if (nextStates.size() == 0) {
                break;
            }
            for (State s : nextStates) {
                if (s.word.equals(endWord)) {
                    found = true;
                    List<String> r = new ArrayList<>();
                    State ss = s;
                    while (ss != null) {
                        r.add(ss.word);
                        ss = ss.prev;
                    }
                    Collections.reverse(r);
                    res.add(r);
                }
            }
            used.addAll(needToBeRemoved);
            unused.removeAll(needToBeRemoved);
        }
        return res;
    }

    class State {
        String word;
        State prev;

        State(String w, State p) {
            word = w;
            prev = p;
        }
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
