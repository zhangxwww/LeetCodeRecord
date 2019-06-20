/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (42.12%)
 * Total Accepted:    314.1K
 * Total Submissions: 744.4K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int last = head.val;
        ListNode p = head.next;
        ListNode q = head;
        int v;
        while (p != null) {
            v =  p.val;
            if (v != last) {
                q.next = p;
                q = q.next;
                last = v;
            }
            p = p.next;
        }
        q.next = null;
        return head;
    }
}
