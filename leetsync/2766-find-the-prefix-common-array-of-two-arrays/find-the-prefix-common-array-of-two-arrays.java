class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {

        int size = a.length;
        int[] result = new int[size];
        int matchingCount = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(a[i]);
            matchingCount = 0;
            for (int j = 0; j <= i; j++) {
                if (set.contains(b[j])) {
                    matchingCount++;
                }
            }
            result[i] = matchingCount;
        }
        return result;
    }
}