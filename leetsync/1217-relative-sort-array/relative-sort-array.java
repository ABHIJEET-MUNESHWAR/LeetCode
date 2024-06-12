class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int size1 = arr1.length;
        int size2 = arr2.length;
        int[] result = new int[size1];
        int[] frequencyMap = new int[1001];
        for (int i = 0; i < size1; i++) {
            frequencyMap[arr1[i]]++;
        }
        int j = 0;
        for (int i = 0; i < size2; i++) {
            while (frequencyMap[arr2[i]] > 0) {
                result[j++] = arr2[i];
                frequencyMap[arr2[i]]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (frequencyMap[i] > 0) {
                result[j++] = i;
                frequencyMap[i]--;
            }
        }
        return result;
    }
}