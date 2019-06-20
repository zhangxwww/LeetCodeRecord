/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (46.36%)
 * Total Accepted:    538.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
            p.next = null;
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
            p.next = null;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
            p.next = null;
        }
        return head.next;
    }
}
