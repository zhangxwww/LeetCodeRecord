import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        sort(nums, 0, len - 1);
        HashMap<Integer, List<Integer>> sf = new HashMap<>();
        HashMap<Integer, List<Integer>> ss = new HashMap<>();
        int[][] sum2 = new int[len][len];
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int t = nums[i] + nums[j];
                sum2[i][j] = t;
                sf.put(t, new ArrayList<>());
                ss.put(t, new ArrayList<>());
            }
        }
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                int t = sum2[i][j];
                sf.get(t).add(i);
                ss.get(t).add(j);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int pre_f = -1;
        boolean pre_f_init = false;
        for (int i = 0; i < len - 3; ++i) {
            if (pre_f_init && nums[i] == pre_f) {
                continue;
            }
            pre_f = nums[i];
            pre_f_init = true;

            int pre_s = -1;
            boolean pre_s_init = false;
            for (int j = i + 1; j < len - 2; ++j) {
                if (pre_s_init && nums[j] == pre_s) {
                    continue;
                }
                pre_s = nums[j];
                pre_s_init = true;

                int t = target - nums[i] - nums[j];
                if (!sf.containsKey(t)) {
                    continue;
                }
                List<Integer> tsf = sf.get(t);
                List<Integer> tss = ss.get(t);
                int pre_t = 0;
                boolean pre_t_init = false;
                int count = tsf.size();
                for (int k = 0; k < count; ++k) {
                    if (tsf.get(k) <= j || pre_t_init && nums[tsf.get(k)] == pre_t) {
                        continue;
                    }
                    pre_t = nums[tsf.get(k)];
                    pre_t_init = true;
                    res.add(Arrays.asList(nums[i], nums[j], nums[tsf.get(k)], nums[tss.get(k)]));
                }
            }
        }
        return res;
    }

    private void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[i];
        while (i < j) {
            while (i < j && x <= a[j]) {
                --j;
            }
            a[i] = a[j];
            while (i < j && x >= a[i]) {
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = x;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
}
