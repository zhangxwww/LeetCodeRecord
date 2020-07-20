/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    private int[] fact;
    private boolean[] used = new boolean[9];

    public String getPermutation(int n, int k) {
        callFact();
        --k;
        int resint = 0;
        while (n > 2) {
            resint = resint * 10 + findKthUnused(k / fact[n - 1]);
            k = k % fact[n - 1];
            --n;
        }

        return String.valueOf(resint);
    }

    private void callFact() {
        fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i < 10; ++i) {
            fact[i] = fact[i - 1] * i;
        }
    }

    private int findKthUnused(int k) {
        for (int i = 0; i < 9; ++i) {
            if (!used[i]) {
                --k;
                if (k == -1) {
                    used[i] = true;
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
