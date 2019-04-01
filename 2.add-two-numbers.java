/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.81%)
 * Total Accepted:    811K
 * Total Submissions: 2.6M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            carry = 0;
            if (v > 9) {
                v -= 10;
                carry = 1;
            }
            p.next = new ListNode(v);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            p.next = null;
        }
        while (l1 != null) {
            int v = l1.val + carry;
            carry = 0;
            if (v > 9) {
                v -= 10;
                carry = 1;
            }
            p.next = new ListNode(v);
            p = p.next;
            l1 = l1.next;
            p.next = null;
        }
        while (l2 != null) {
            int v = l2.val + carry;
            carry = 0;
            if (v > 9) {
                v -= 10;
                carry = 1;
            }
            p.next = new ListNode(v);
            p = p.next;
            l2 = l2.next;
            p.next = null;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
}
