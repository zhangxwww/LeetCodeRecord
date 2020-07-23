import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {

    private class Head {
        Node next;
        int width;
        int start;
        int end;
    }

    private class Node {
        Node next;
        Node prev;
        Head head;
        int pos;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        List<Head> headList = new ArrayList<>();
        Map<Integer, List<Node>> level2Node = new HashMap<>();

        Head head = new Head();
        head.start = 0;
        head.end = n;
        head.width = n;

        headList.add(head);

        Node p = null;
        for (int i = 0; i < n; ++i) {
            Node node = new Node();
            node.prev = p;
            node.pos = i;
            node.head = head;
            if (i == 0) {
                head.next = node;
            }
            if (p != null) {
                p.next = node;
            }
            p = node;

            int height = heights[i];
            if (!level2Node.containsKey(height)) {
                level2Node.put(height, new ArrayList<>());
            }
            level2Node.get(height).add(node);
        }

        Set<Integer> heightSet = new HashSet<>();
        for (int height : heights) {
            heightSet.add(height);
        }
        Set<Integer> heightTreeSet = new TreeSet<Integer>(heightSet);
        Integer[] hs = heightTreeSet.toArray(new Integer[] {});

        int maxArea = 0;

        split(headList, level2Node.get(0));
        for (int height : hs) {
            for (Head h : headList) {
                int area = h.width * height;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
            split(headList, level2Node.get(height));
        }
        return maxArea;
    }

    private void split(List<Head> headList, List<Node> splitNode) {
        if (splitNode == null) {
            return;
        }
        for (Node node : splitNode) {
            if (node.next == null) {
                Head head = node.head;
                head.end = node.pos;
                head.width = head.end - head.start;
                if (node.prev != null) {
                    node.prev.next = null;
                    node.prev = null;
                }
            } else if (node.prev == null) {
                Head head = node.head;
                head.next = node.next;
                head.start = node.next.pos;
                head.width = head.end - head.start;
                node.next.prev = null;
                node.next = null;
            } else {
                Head leftHead = node.head;
                Head rightHead = new Head();

                rightHead.next = node.next;
                rightHead.start = rightHead.next.pos;
                rightHead.end = leftHead.end;
                rightHead.width = rightHead.end - rightHead.start;

                Node q = rightHead.next;
                while (q != null) {
                    q.head = rightHead;
                    q = q.next;
                }

                leftHead.end = node.pos;
                leftHead.width = leftHead.end - leftHead.start;

                node.prev.next = null;
                node.next.prev = null;
                node.prev = null;
                node.next = null;

                headList.add(rightHead);
            }
        }
        splitNode.clear();
    }
}
// @lc code=end
