class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            // If 2 * arr[i] is already in the set, return true
            int dble = arr[i] * 2;
            int half = arr[i] / 2;
            if ((set.contains(dble)) || ((arr[i] % 2 == 0) && (set.contains(half)))) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}