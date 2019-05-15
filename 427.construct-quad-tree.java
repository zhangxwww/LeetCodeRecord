/*
 * @lc app=leetcode id=427 lang=java
 *
 * [427] Construct Quad Tree
 */
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 0, n, 0, n);
    }

    private Node build(int[][] grid, int top, int bottom, int left, int right) {
        int mid = (right - left) / 2;
        if (mid == 0) {
            return new Node(grid[top][left] == 1, true, null, null, null, null);
        }
        Node tl = build(grid, top, bottom - mid, left, right - mid);
        Node tr = build(grid, top, bottom - mid, left + mid, right);
        Node bl = build(grid, top + mid, bottom, left, right - mid);
        Node br = build(grid, top + mid, bottom, left + mid, right);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            if ((tl.val && tr.val && bl.val && br.val) || !(tl.val || tr.val || bl.val || br.val)) {
                return new Node(tl.val, true, null, null, null, null);
            }
        }
        return new Node(true, false, tl, tr, bl, br);
    }
}
