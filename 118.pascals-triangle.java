
/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (45.05%)
 * Total Accepted:    240.2K
 * Total Submissions: 530.8K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        if (numRows == 1) {
            return res;
        }
        queue.offer(0);
        queue.offer(1);
        queue.offer(1);
        int count = 0;
        int row = 2;
        res.add(new ArrayList<>());
        for (int i = 1; row <= numRows; i++) {
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
        if (res.get(numRows - 1).size() == 0) {
            res.remove(numRows - 1);
        }
        return res;
    }
}
