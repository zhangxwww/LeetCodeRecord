
/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> countQ = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        queue.offer(root);
        countQ.offer(root.children.size());
        int childcount = 1;
        int curCount = 0;
        while (queue.size() > 0) {
            Node node = queue.poll();
            ++curCount;
            level.add(node.val);
            if (curCount == childcount) {
                childcount = 0;
                while (curCount > 0) {
                    childcount += countQ.poll();
                    --curCount;
                }
                res.add(level);
                level = new ArrayList<>();
            }
            for (Node n : node.children) {
                queue.offer(n);
                countQ.offer(n.children.size());
            }
        }
        return res;
    }
}
