
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        int[] count = new int[n];
        sort(candidates, 0, n - 1);
        bt(res, candidates, target, count, n, 0);
        return res;
    }

    private void bt(List<List<Integer>> res, int[] cs, int t, int[] count, int n, int pre) {
        if (t == 0) {
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int c = count[i];
                for (; c > 0; --c) {
                    r.add(cs[i]);
                }
            }
            res.add(r);
            return;
        }
        for (int i = pre; i < n; ++i) {
            int tt = t - cs[i];
            if (tt < 0) {
                break;
            }
            ++count[i];
            bt(res, cs, tt, count, n, i);
            --count[i];
        }
    }

    private void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[low];
        while (i < j) {
            while (i < j && a[j] >= x) {
                --j;
            }
            a[i] = a[j];
            while (i < j && a[i] <= x) {
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = x;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
}
