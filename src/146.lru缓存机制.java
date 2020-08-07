import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    private int cap;
    private int n;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node(null, null, null);
    private Node tail = new Node(null, null, null);

    public LRUCache(int capacity) {
        cap = capacity;
        n = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;

        tail.prev.next = node;
        node.prev = tail.prev;

        tail.prev = node;
        node.next = tail;
        return node.p.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.p.value = value;

            node.prev.next = node.next;
            node.next.prev = node.prev;

            tail.prev.next = node;
            node.prev = tail.prev;

            tail.prev = node;
            node.next = tail;
        } else {
            if (n < cap) {
                node = new Node(new Pair(key, value), null, null);
                n++;
                tail.prev.next = node;
                node.prev = tail.prev;
                tail.prev = node;
                node.next = tail;

                map.put(key, node);
            } else {
                int k = head.next.p.key;
                head.next.p.value = value;
                head.next.p.key = key;
                map.remove(k);
                map.put(key, head.next);

                node = head.next;
                node.prev.next = node.next;
                node.next.prev = node.prev;

                tail.prev.next = node;
                node.prev = tail.prev;

                tail.prev = node;
                node.next = tail;
            }
        }
    }

    class Pair {
        int key, value;

        Pair(int k, int v) {
            key = k;
            value = v;
        }
    }

    class Node {
        Pair p;
        Node next;
        Node prev;

        Node(Pair pp, Node n, Node pr) {
            p = pp;
            next = n;
            prev = pr;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
