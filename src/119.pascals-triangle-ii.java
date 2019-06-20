import java.util.List;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (42.58%)
 * Total Accepted:    194.1K
 * Total Submissions: 453.6K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList<>();
        if (rowIndex == 0) {
            r.add(1);
            return r;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        ++rowIndex;

        queue.offer(0);
        queue.offer(1);
        queue.offer(1);
        int count = 0;
        int row = 2;
        res.add(new ArrayList<>());
        for (int i = 1; row <= rowIndex; i++) {
            queue.offer(0);
            for (int j = 1; j <= 2 + i; j++) {
                int s = queue.poll();
                int e = queue.peek();
                if (e != 0) {
                    ++count;
                    if (res.size() < row) {
                        res.add(new ArrayList<>());
                    }
                    res.get(row - 1).add(e);
                    if (count == row) {
                        ++row;
                        count = 0;
                    }
                }
                queue.offer(s + e);
            }
        }
        return res.get(rowIndex - 1);
    }
}
