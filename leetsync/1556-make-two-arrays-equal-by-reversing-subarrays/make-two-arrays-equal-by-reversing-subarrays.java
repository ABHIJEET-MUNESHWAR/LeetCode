class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        int size = target.length;
        for (int i = 0; i < size; i++) {
            count[target[i]]++;
            count[arr[i]]--;
        }
        for (int i = 0; i < 1001; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}