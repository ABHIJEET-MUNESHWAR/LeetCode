class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {

        int size = arr.length;
        if (size < 3) {
            return false;
        }
        int i = 0, j = 1, k = 2;
        while (i < size && j < size && k < size) {
            if (arr[i] % 2 == 1 && arr[j] % 2 == 1 && arr[k] % 2 == 1) {
                return true;
            }
            i++;
            j++;
            k++;
        }
        return false;
    }
}