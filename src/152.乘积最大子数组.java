/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int d = nums[0] >= 0 ? nums[0] : 0;
        int e = nums[0] <= 0 ? nums[0] : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                d = 0;
                e = 0;
            } else if (nums[i] < 0) {
                int nd = e * nums[i];
                int ne = nums[i] * (d > 1 ? d : 1);
                d = nd;
                e = ne;
            } else {
                e = e * nums[i];
                d = nums[i] * (d > 1 ? d : 1);
            }
            if (d > res) {
                res = d;
            }
        }
        return res;
    }
}
// @lc code=end
