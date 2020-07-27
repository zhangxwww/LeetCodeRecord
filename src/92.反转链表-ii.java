/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == m) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        ListNode q = null;
        ListNode r = null;
        ListNode s = null;
        int cur = 1;
        while (cur <= n) {
            if (cur == m) {
                r = p.next;
                s = r;
                q = r.next;
            } else if (cur > m) {
                p.next = q;
                s.next = q.next;
                q.next = r;
                r = q;
                q = s.next;
            } else if (cur < m) {
                p = p.next;
            }
            ++cur;
        }
        return h.next;
    }
}
// @lc code=end
