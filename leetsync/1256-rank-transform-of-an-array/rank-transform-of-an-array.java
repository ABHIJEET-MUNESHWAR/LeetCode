class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] A = Arrays.copyOf(arr, n);
        Arrays.sort(A);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int num : A) {
            rankMap.putIfAbsent(num, rankMap.size() + 1);
        }
        for (int i = 0; i < n; i++) {
            A[i] = rankMap.get(arr[i]);
        }
        return A;
    }
}