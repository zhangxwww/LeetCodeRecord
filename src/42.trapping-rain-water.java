/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
  public int trap(int[] height) {
    int len = height.length;
    if (len <= 2) {
      return 0;
    }
    int total = 0;

    Node head = new Node(null, null, (int) 0x80000000, 1);
    Node p = head;
    for (int h : height) {
      Node q = new Node(p, null, h, 1);
      p.right = q;
      p = q;
    }
    p = head.right.right;

    while (p != null && (p.right != null) && (p.left != null)) {
      boolean change = false;
      int h = p.height;
      int lh = p.left.height;
      int rh = p.right.height;
      while (h == rh && p.right != null) {
        change = true;
        p = mergeRightNode(p);
        if (p.right != null) {
          rh = p.right.height;
        }
      }
      while (h == lh && p.left != null) {
        change = true;
        p = mergeLeftNode(p);
        if (p.left != null) {
          lh = p.left.height;
        }
      }
      while (lh > h && h < rh && p.left != null && p.right != null) {
        change = true;
        if (lh <= rh) {
          total += (lh - h) * p.length;
          p = mergeLeftNode(p);
          h = lh;
          if (p.left != null) {
            lh = p.left.height;
          }
        } else {
          total += (rh - h) * p.length;
          p = mergeRightNode(p);
          h = rh;
          if (p.right != null) {
            rh = p.right.height;
          }
        }
      }
      if (!change) {
        p = p.right;
      }
    }

    return total;
  }

  private Node mergeRightNode(Node node) {
    if (node == null || node.right == null) {
      return node.left;
    }
    Node q = node.right;
    node.right = q.right;
    if (q.right != null) {
      q.right.left = node;
    }
    node.length += q.length;
    node.height = q.height;
    return node;
  }

  private Node mergeLeftNode(Node node) {
    if (node == null || node.left == null) {
      return node.left;
    }
    Node q = node.left;
    q.right = node.right;
    if (node.right != null) {
      node.right.left = q;
    }
    q.length += node.length;
    return q;
  }

  private class Node {
    Node left;
    Node right;
    int height;
    int length;

    public Node(Node left, Node right, int height, int length) {
      this.left = left;
      this.right = right;
      this.height = height;
      this.length = length;
    }
  }
}
