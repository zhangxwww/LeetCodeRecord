/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessListHead = new ListNode(0);
        ListNode geqListHead = new ListNode(0);

        ListNode p = head;
        ListNode less = lessListHead;
        ListNode geq = geqListHead;
        while (p != null) {
            if (p.val < x) {
                less.next = p;
                p = p.next;
                less.next.next = null;
                less = less.next;
            } else {
                geq.next = p;
                p = p.next;
                geq.next.next = null;
                geq = geq.next;
            }
        }

        less.next = geqListHead.next;
        return lessListHead.next;
    }
}
// @lc code=end
