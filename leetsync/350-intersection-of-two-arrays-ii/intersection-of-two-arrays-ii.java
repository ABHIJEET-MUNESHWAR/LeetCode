class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> num3ArrayList = new ArrayList<>();
        int j = 0, i = 0;
        if (l1 < l2) {
          while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
              num3ArrayList.add(nums1[i]);
              i++;
              j++;
            } else if (nums1[i] < nums2[j]) {
              i++;
            } else {
              j++;
            }
          }
        } else {
          j = 0;
          i = 0;
          while (j < l1 && i < l2) {
            if (nums2[i] == nums1[j]) {
              num3ArrayList.add(nums1[j]);
              i++;
              j++;
            } else if (nums2[i] < nums1[j]) {
              i++;
            } else {
              j++;
            }
          }
        }
        return num3ArrayList.stream().mapToInt(m -> m).toArray();
    }
}