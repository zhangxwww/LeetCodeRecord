/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int n = 0;
        ListNode pp = head;
        while (pp != null) {
            ++n;
            pp = pp.next;
        }
        ListNode rh = new ListNode(-1);
        rh.next = head;
        ListNode r = rh;
        for (int i = k; i <= n; i += k) {
            ListNode p = r.next;
            ListNode q = p;
            ListNode s = q.next;
            for (int j = 0; j < k - 1; ++j) {
                r.next = s;
                s = s.next;
                r.next.next = q;
                p.next = s;
                q = r.next;
            }
            r = p;
        }
        return rh.next;
    }
}
