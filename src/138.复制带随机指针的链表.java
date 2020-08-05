import java.util.HashMap;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();

        Node p = head;

        Node h = new Node(0);
        Node q = h;

        while (p != null) {
            q.next = map.get(p);
            if (q.next == null) {
                q.next = new Node(p.val);
                map.put(p, q.next);
            }
            if (p.random != null) {
                Node r = map.get(p.random);
                if (r == null) {
                    r = new Node(p.random.val);
                    map.put(p.random, r);
                }
                q.next.random = r;
            }
            p = p.next;
            q = q.next;
        }
        return h.next;
    }
}
// @lc code=end
