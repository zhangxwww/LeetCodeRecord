/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node p = root;
        while (p != null) {
            Node q = p;
            Node r = null;
            while (q != null) {
                while (q.left == null && q.right == null) {
                    q = q.next;
                    if (q == null) {
                        break;
                    }
                }
                if (q == null) {
                    break;
                }
                if (q.left != null) {
                    if (r == null) {
                        r = q.left;
                    } else {
                        r.next = q.left;
                        r = q.left;
                    }
                }
                if (q.right != null) {
                    if (r == null) {
                        r = q.right;
                    } else {
                        r.next = q.right;
                        r = q.right;
                    }
                }
                q = q.next;
            }
            while (p.left == null && p.right == null) {
                p = p.next;
                if (p == null) {
                    break;
                }
            }
            if (p == null) {
                break;
            }
            if (p.left != null) {
                p = p.left;
            } else if (p.right != null) {
                p = p.right;
            }
        }
        return root;
    }
}
// @lc code=end
