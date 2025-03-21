
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> resultList = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];
            if (id1 == id2) {
                resultList.add(new int[] { id1, nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (id1 < id2) {
                resultList.add(new int[] { id1, nums1[i][1] });
                i++;
            } else {
                resultList.add(new int[] { id2, nums2[j][1] });
                j++;
            }
        }
        while (i < len1) {
            resultList.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }
        while (j < len2) {
            resultList.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }
        int len = resultList.size();
        int[][] result = new int[len][2];
        for (i = 0; i < len; i++) {
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }
        return result;
    }
}