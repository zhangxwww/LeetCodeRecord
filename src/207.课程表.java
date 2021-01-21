import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    Map<Integer, List<Integer>> succ = new HashMap<>();
    Map<Integer, Set<Integer>> prio = new HashMap<>();
    Set<Integer> learned = new HashSet<>();
    Set<Integer> starts = new HashSet<>();
    Set<Integer> related = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int[] pair = prerequisites[i];
            int pre = pair[1];
            int suc = pair[0];
            if (!succ.containsKey(pre)) {
                succ.put(pre, new ArrayList<>());
            }
            succ.get(pre).add(suc);
            if (!prio.containsKey(suc)) {
                prio.put(suc, new HashSet<>());
            }
            prio.get(suc).add(pre);
            related.add(pre);
            related.add(suc);
        }
        for (int pre : succ.keySet()) {
            Set<Integer> p = prio.get(pre);
            if (p == null || p.size() == 0) {
                starts.add(pre);
            }
        }
        learned.addAll(starts);
        for (int s : starts) {
            dfs(s);
        }
        return learned.size() == related.size();
    }

    private void dfs(int course) {
        if (!succ.containsKey(course)) {
            return;
        }
        List<Integer> s = succ.get(course);
        for (int suc : s) {
            if (learned.contains(suc)) {
                continue;
            }
            prio.get(suc).remove(course);
            if (prio.get(suc).size() == 0) {
                learned.add(suc);
                dfs(suc);
            }
        }
    }
}
// @lc code=end
