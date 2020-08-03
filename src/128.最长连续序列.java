import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> left2Range = new HashMap<>();
        HashMap<Integer, Integer> right2Range = new HashMap<>();
        HashMap<Integer, Integer> range2Left = new HashMap<>();
        HashMap<Integer, Integer> range2Right = new HashMap<>();
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        HashSet<Integer> used = new HashSet<>();

        int maxLen = 0;

        int rangeIndex = 0;
        for (int i : nums) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            int len = 0;
            boolean hasLeft = right2Range.containsKey(i - 1);
            boolean hasRight = left2Range.containsKey(i + 1);
            if (hasLeft && hasRight) {
                int leftRangeIndex = right2Range.get(i - 1);
                int rightRangeIndex = left2Range.get(i + 1);
                int rightRight = range2Right.get(rightRangeIndex);
                int leftLen = lenMap.get(leftRangeIndex);
                int rightLen = lenMap.get(rightRangeIndex);

                right2Range.put(rightRight, leftRangeIndex);
                range2Right.put(leftRangeIndex, rightRight);

                range2Left.remove(rightRangeIndex);
                range2Right.remove(rightRangeIndex);

                right2Range.remove(i - 1);
                left2Range.remove(i + 1);

                lenMap.remove(rightRangeIndex);

                len = leftLen + rightLen + 1;
                lenMap.put(leftRangeIndex, len);
            } else if (hasLeft) {
                int leftRangeIndex = right2Range.get(i - 1);

                right2Range.remove(i - 1);
                right2Range.put(i, leftRangeIndex);

                range2Right.put(leftRangeIndex, i);

                len = lenMap.get(leftRangeIndex) + 1;
                lenMap.put(leftRangeIndex, len);
            } else if (hasRight) {
                int rightRangeIndex = left2Range.get(i + 1);

                left2Range.remove(i + 1);
                left2Range.put(i, rightRangeIndex);

                range2Left.put(rightRangeIndex, i);

                len = lenMap.get(rightRangeIndex) + 1;
                lenMap.put(rightRangeIndex, len);
            } else {
                left2Range.put(i, rangeIndex);
                right2Range.put(i, rangeIndex);
                range2Left.put(rangeIndex, i);
                range2Right.put(rangeIndex, i);
                lenMap.put(rangeIndex, 1);
                ++rangeIndex;
                len = 1;
            }
            maxLen = maxLen < len ? len : maxLen;
        }
        return maxLen;
    }
}
// @lc code=end
