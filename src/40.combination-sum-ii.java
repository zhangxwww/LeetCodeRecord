import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    int len = candidates.length;
    HashSet<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < len; ++i) {
      backtrace(res, set, candidates, i, 0, target, new int[len], 0, len);
    }
    return res;
  }

  private void backtrace(List<List<Integer>> res, HashSet<List<Integer>> set, int[] candidates, int cur, int curSum,
      int target, int[] path, int depth, int maxDepth) {
    if (depth == maxDepth || cur >= maxDepth) {
      return;
    }
    int sum = curSum + candidates[cur];
    path[depth] = candidates[cur];
    if (sum > target) {
      return;
    } else if (sum == target) {
      List<Integer> r = new ArrayList<>();
      for (int i = 0; i <= depth; ++i) {
        r.add(path[i]);
      }
      if (!set.contains(r)) {
        set.add(r);
        res.add(r);
      }
    } else {
      for (int i = cur + 1; i < maxDepth; ++i) {
        backtrace(res, set, candidates, i, sum, target, path, depth + 1, maxDepth);
      }
    }
  }
}
