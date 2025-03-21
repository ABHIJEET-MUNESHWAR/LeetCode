class Solution {
    public int countTriplets(int[] arr) {

        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int temp1 = 0;
            for (int j = i + 1; j < size; j++) {
                temp1 ^= arr[j - 1];
                int temp2 = 0;
                for (int k = j; k < size; k++) {
                    temp2 ^= arr[k];
                    if (temp1 == temp2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}