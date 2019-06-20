/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        sort(nums1, 0, l1 - 1);
        sort(nums2, 0, l2 - 1);
        int[] r = new int[l1 < l2 ? l1 : l2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                r[k] = nums1[i];
                ++i;
                ++j;
                ++k;
            }
        }
        int[] res = new int[k];
        System.arraycopy(r, 0, res, 0, k);
        return res;
    }

    private void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) {
                --j;
            }
            a[i] = a[j];
            while (i < j && a[i] <= x) {
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = x;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }
}
