class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int size = a.length;
        int[] result = new int[size];
        int[] visited = new int[size + 1];
        int currentCount = 0;
        for (int i = 0; i < size; i++) {
            if (++visited[a[i]] == 2) {
                currentCount++;
            }
            if (++visited[b[i]] == 2) {
                currentCount++;
            }
            result[i] = currentCount;
        }
        return result;
    }
}