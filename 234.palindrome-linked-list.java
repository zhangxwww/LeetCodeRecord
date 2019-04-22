/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (35.55%)
 * Total Accepted:    248.1K
 * Total Submissions: 693.9K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode tail = head;
        ListNode middle = head;
        while (true) {
            if (tail.next != null) {
                tail = tail.next;
            } else {
                break;
            }
            if (tail.next != null) {
                middle = middle.next;
                tail = tail.next;
            } else {
                break;
            }
        }
        ListNode tmp = middle;
        middle = middle.next;
        tmp.next = null;
        if (middle == tail) {
            return head.val == tail.val;
        }
        ListNode p = middle;
        ListNode q = p.next;
        ListNode r = p;
        while (q != tail) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        middle.next = null;
        tail.next = p;

        p = head;
        while (p != null) {
            p = p.next;
        }
        p = tail;
        while (p != null) {
            p = p.next;
        }

        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
