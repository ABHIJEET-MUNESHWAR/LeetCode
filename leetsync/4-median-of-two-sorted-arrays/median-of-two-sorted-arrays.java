class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int index1 = (size / 2) - 1;
        int element1 = -1;
        int index2 = (size / 2);
        int element2 = -1;

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == index1) {
                    element1 = nums1[i];
                }
                if (k == index2) {
                    element2 = nums1[i];
                }
                i++;
            } else {
                if (k == index1) {
                    element1 = nums2[j];
                }
                if (k == index2) {
                    element2 = nums2[j];
                }
                j++;
            }
            k++;
        }
        while (i < m) {
            if (k == index1) {
                element1 = nums1[i];
            }
            if (k == index2) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }
        while (j < n) {
            if (k == index1) {
                element1 = nums2[j];
            }
            if (k == index2) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }
        double result = 0;
        if (size % 2 == 0) {
            result = (element1 + element2) / 2.0;
        } else {
            result = element2;
        }
        return result;
    }
}