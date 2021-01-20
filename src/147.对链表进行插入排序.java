/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode h = new ListNode(0x80000000, head);
        if (head == null) {
            return head;
        }
        ListNode fine = head;
        while (fine.next != null) {
            ListNode next = fine.next;
            if (next.val >= fine.val) {
                fine = fine.next;
                continue;
            }
            ListNode pre = h;
            while (pre.next.val < next.val) {
                pre = pre.next;
            }
            fine.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return h.next;
    }
}
// @lc code=end
