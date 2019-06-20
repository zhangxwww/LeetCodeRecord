/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        sort(nums1, 0, l1 - 1);
        sort(nums2, 0, l2 - 1);
        int l = l1 < l2 ? l1 : l2;
        int[] res = new int[l];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                if (k == 0 || (k > 0 && res[k - 1] != nums1[i])) {
                    res[k++] = nums1[i];
                }
                ++i;
                ++j;
            }
        }
        int[] r = new int[k];
        System.arraycopy(res, 0, r, 0, k);
        return r;
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
