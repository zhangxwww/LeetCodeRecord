/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (51.21%)
 * Total Accepted:    322K
 * Total Submissions: 625.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        int[] primes = new int[] { 5, 11, 23, 53, 101, 199, 401, 601, 797, 1013, 2003, 110017 };
        int p = 7;
        for (int pp : primes) {
            if (pp > len) {
                p = pp;
                break;
            }
        }
        Node[] hashtable = new Node[p];
        for (int x : nums) {
            if (findAndInsert(hashtable, x, p)) {
                return true;
            }
        }
        return false;
    }

    private boolean findAndInsert(Node[] hashtable, int x, int p) {
        int pos = (x >= 0 ? x : -x) % p;
        Node head = hashtable[pos];
        if (head == null) {
            hashtable[pos] = new Node(x);
            return false;
        } else {
            if (head.val == x) {
                return true;
            }
            while (head.next != null) {
                if (head.next.val == x) {
                    return true;
                }
                head = head.next;
            }
            head.next = new Node(x);
            return false;
        }
    }

    private class Node {
        Node next;
        int val;

        Node(int v) {
            next = null;
            val = v;
        }
    }
}
