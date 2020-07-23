/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        while (p != null && p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int val = p.next.val;
                ListNode q = p.next.next.next;
                while (q != null && q.val == val) {
                    q = q.next;
                }
                p.next = q;
                continue;
            }
            p = p.next;
        }
        return h.next;
    }
}
// @lc code=end
