/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.82%)
 * Total Accepted:    404K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0) {
            if (n2 % 2 == 0) {
                return (nums2[n2 / 2] + nums2[n2 / 2 - 1]) / 2.0;
            } else {
                return nums2[n2 / 2];
            }
        } else if (n2 == 0) {
            if (n1 % 2 == 0) {
                return (nums1[n1 / 2] + nums1[n1 / 2 - 1]) / 2.0;
            } else {
                return nums1[n1 / 2];
            }
        } else {
            if ((n1 + n2) % 2 == 0) {
                return (findDownMedian(nums1, 0, n1 - 1, nums2, 0, n2 - 1)
                        + findUpMedian(nums1, 0, n1 - 1, nums2, 0, n2 - 1)) / 2.0;
            } else {
                return findDownMedian(nums1, 0, n1 - 1, nums2, 0, n2 - 1);
            }
        }
    }

    private int findDownMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        int m1 = (start1 + end1) / 2;
        int m2 = (start2 + end2) / 2;
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 == 1 && len2 == 1) {
            return (nums1[start1] < nums2[start2]) ? nums1[start1] : nums2[start2];
        }
        if (len1 == 1) {
            if (len2 % 2 == 0) {
                if (nums2[m2] <= nums1[start1] && nums1[start1] <= nums2[m2 + 1]) {
                    return nums1[start1];
                } else if (nums1[start1] < nums2[m2]) {
                    return nums2[m2];
                } else {
                    return nums2[m2 + 1];
                }
            } else {
                if (nums1[start1] < nums2[m2 - 1]) {
                    return nums2[m2 - 1];
                } else if (nums2[m2] < nums1[start1]) {
                    return nums2[m2];
                } else {
                    return nums1[start1];
                }
            }
        }
        if (len2 == 1) {
            if (len1 % 2 == 0) {
                if (nums2[start2] < nums1[m1]) {
                    return nums1[m1];
                } else if (nums1[m1 + 1] < nums2[start2]) {
                    return nums1[m1 + 1];
                } else {
                    return nums2[start2];
                }
            } else {
                if (nums2[start2] < nums1[m1 - 1]) {
                    return nums1[m1 - 1];
                } else if (nums1[m1] < nums2[start2]) {
                    return nums1[m1];
                } else {
                    return nums2[start2];
                }
            }
        }
        if (nums1[m1] == nums2[m2]) {
            return nums1[m1];
        } else if (nums1[m1] < nums2[m2]) {
            int l = (len1 < len2) ? len1 / 2 : len2 / 2;
            return findDownMedian(nums1, start1 + l, end1, nums2, start2, end2 - l);
        } else { // >
            int l = (len1 < len2) ? len1 / 2 : len2 / 2;
            return findDownMedian(nums1, start1, end1 - l, nums2, start2 + l, end2);
        }
    }

    private int findUpMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        int m1 = (start1 + end1) / 2 + 1;
        int m2 = (start2 + end2) / 2 + 1;
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 == 1 && len2 == 1) {
            return (nums1[start1] > nums2[start2]) ? nums1[start1] : nums2[start2];
        }
        if (len1 == 1) {
            if (len2 % 2 == 0) {
                if (nums1[start1] < nums2[m2 - 1]) {
                    return nums2[m2 - 1];
                } else if (nums1[start1] > nums2[m2]) {
                    return nums2[m2];
                } else {
                    return nums1[start1];
                }
            } else {
                if (nums1[start1] < nums2[m2 - 1]) {
                    return nums2[m2 - 1];
                } else if (nums1[start1] > nums2[m2]) {
                    return nums2[m2];
                } else {
                    return nums1[start1];
                }
            }
        }
        if (len2 == 1) {
            if (len1 % 2 == 0) {
                if (nums2[start2] < nums1[m1 - 1]) {
                    return nums1[m1 - 1];
                } else if (nums2[start2] > nums1[m1]) {
                    return nums1[m1];
                } else {
                    return nums2[start2];
                }
            } else {
                if (nums2[start2] < nums1[m1 - 1]) {
                    return nums1[m1 - 1];
                } else if (nums2[start2] > nums1[m1]) {
                    return nums1[m1];
                } else {
                    return nums2[start2];
                }
            }
        }
        if (nums1[m1] == nums2[m2]) {
            return nums1[m1];
        } else if (nums1[m1] < nums2[m2]) {
            // int l1 = m1 - start1;
            // int l2 = end2 - m2 + 1;
            // int l = (l1 < l2) ? l1 : l2;
            int l = (len1 < len2) ? len1 / 2 : len2 / 2;
            return findUpMedian(nums1, start1 + l, end1, nums2, start2, end2 - l);
        } else {
            // int l1 = end1 - m1 + 1;
            // int l2 = m2 - start2;
            // int l = (l1 < l2) ? l1 : l2;
            int l = (len1 < len2) ? len1 / 2 : len2 / 2;
            return findUpMedian(nums1, start1, end1 - l, nums2, start2 + l, end2);
        }
    }
}
