class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        // Insert all prefixes of elements from arr1 into the set
        for (int num : arr1) {
            while (!set.contains(num) & num > 0) {
                set.add(num);
                num = num / 10; // Trim last digit
            }
        }
        int result = 0; // LCP
        for (int num : arr2) {
            while (!set.contains(num) & num > 0) {
                num = num / 10; // Trim last digit
            }
            if (num > 0) {
                result = Math.max(result, (int) Math.log10(num) + 1);
            }
        }
        return result;
    }
}