/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (34.90%)
 * Total Accepted:    191.6K
 * Total Submissions: 546.7K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
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
        for (int i = 0; i < len; ++i) {
            if (findAndInsert(hashtable, p, nums[i], i, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean findAndInsert(Node[] hashtable, int p, int x, int index, int k) {
        int pos = (x >= 0 ? x / 2 : -(x / 2)) % p;
        Node head = hashtable[pos];
        if (head == null) {
            hashtable[pos] = new Node(x, index);
            return false;
        } else {
            if (head.val == x && index - k <= head.index && index + k >= head.index) {
                return true;
            }
            while (head.next != null) {
                if (head.next.val == x && index - k <= head.next.index && index + k >= head.next.index) {
                    return true;
                }
                head = head.next;
            }
            head.next = new Node(x, index);
            return false;
        }
    }

    class Node {
        int val;
        Node next;
        int index;

        Node(int v, int idx) {
            next = null;
            val = v;
            index = idx;
        }
    }
}
