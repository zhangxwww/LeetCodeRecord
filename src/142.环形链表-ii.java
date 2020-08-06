/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        int len = 0;
        while (true) {
            fast = fast.next;
            ++len;
            if (fast == meet) {
                break;
            }
        }
        fast = head;
        slow = head;
        for (int i = 0; i < len; ++i) {
            fast = fast.next;
        }
        while (true) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}
// @lc code=end
