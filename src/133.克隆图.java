import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.offer(node);
        visited.add(node);

        while (!q.isEmpty()) {
            Node n = q.poll();

            Node newNode = map.get(n.val);
            if (newNode == null) {
                newNode = new Node(n.val);
                map.put(n.val, newNode);
            }

            for (Node nei : n.neighbors) {
                if (!visited.contains(nei)) {
                    q.offer(nei);
                    visited.add(nei);
                }
                Node newNei = map.get(nei.val);
                if (newNei == null) {
                    newNei = new Node(nei.val);
                    map.put(nei.val, newNei);
                }
                newNode.neighbors.add(newNei);
            }
        }
        return map.get(node.val);
    }
}
// @lc code=end
