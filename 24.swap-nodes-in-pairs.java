/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode rh = new ListNode(-1);
        rh.next = head;
        ListNode r = rh;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            r.next = q;
            p.next = q.next;
            q.next = p;
            r = p;
            p = p.next;
        }
        return rh.next;
    }
}
