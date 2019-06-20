/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (33.53%)
 * Total Accepted:    369.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return lists[0];
        }
        int inf = 0x7fffffff;
        int[] loserTree = new int[2 * k + 1];
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                loserTree[i + k] = lists[i].val;
            } else {
                loserTree[i + k] = inf;
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        createLoserTree(loserTree, k);
        while (loserTree[k + loserTree[0]] != inf) {
            int q = loserTree[0];
            p.next = new ListNode(lists[q].val);
            p = p.next;
            lists[q] = lists[q].next;
            int val;
            if (lists[q] == null) {
                val = inf;
            } else {
                val = lists[q].val;
            }
            loserTree[k + q] = val;
            adjust(loserTree, q, k);
        }
        if (lists[loserTree[0]] != null) {
            p.next = new ListNode(lists[loserTree[0]].val);
        }
        return head.next;
    }

    private void createLoserTree(int[] loserTree, int k) {
        loserTree[2 * k] = 0x80000000;
        for (int i = 0; i < k; ++i) {
            loserTree[i] = k;
        }
        for (int i = k - 1; i >= 0; --i) {
            adjust(loserTree, i, k);
        }
    }

    private void adjust(int[] loserTree, int q, int k) {
        int parent = (q + k) / 2;
        while (parent > 0) {
            if (loserTree[q + k] > loserTree[k + loserTree[parent]]) {
                int temp = q;
                q = loserTree[parent];
                loserTree[parent] = temp;
            }
            parent /= 2;
        }
        loserTree[0] = q;
    }
}
