/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int point_1 = 0;
        int point_2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            switch (nums[i]) {
                case 0:
                    nums[i] = 2;
                    nums[point_2++] = 1;
                    nums[point_1++] = 0;
                    break;
                case 1:
                    nums[i] = 2;
                    nums[point_2++] = 1;
                    break;
                case 2:
                    break;
            }
        }
    }
}
// @lc code=end
