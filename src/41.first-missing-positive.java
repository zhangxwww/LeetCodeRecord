/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class Solution {
  public int firstMissingPositive(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; ++i) {
      int j = nums[i];
      while (0 < j && j <= len) {
        if (j - 1 != i && nums[j - 1] != nums[i]) {
          int tmp = nums[j - 1];
          nums[j - 1] = nums[i];
          nums[i] = tmp;
          j = nums[i];
        } else {
          break;
        }
      }
    }
    for (int i = 0; i < len; ++i) {
      if (nums[i] - 1 != i) {
        return i + 1;
      }
    }
    return len + 1;
  }
}
