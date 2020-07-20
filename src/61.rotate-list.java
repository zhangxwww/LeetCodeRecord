/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            ++len;
            tail = tail.next;
        }
        k = k % len;
        k = len - k;
        k = k % len;
        if (k == 0 || len == 1) {
            return head;
        }
        ListNode p = head;
        while (k > 1) {
            --k;
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        tail.next = head;
        return newHead;
    }
}
// @lc code=end
