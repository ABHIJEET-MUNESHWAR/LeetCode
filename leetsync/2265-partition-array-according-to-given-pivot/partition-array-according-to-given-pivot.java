class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int size = nums.length;
        int[] answer = new int[size];
        int totalNumbersLesserThanPivot = 0;
        int totalNumbersGreaterThanPivot = 0;
        int totalNumbersEqualToPivot = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] > pivot) {
                totalNumbersGreaterThanPivot++;
            } else if (nums[i] == pivot) {
                totalNumbersEqualToPivot++;
            } else {
                totalNumbersLesserThanPivot++;
            }
        }
        int[] lesserArray = new int[totalNumbersLesserThanPivot];
        int[] greaterArray = new int[totalNumbersGreaterThanPivot];
        int[] equalArray = new int[totalNumbersEqualToPivot];
        int j = 0, k = 0, l = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] < pivot) {
                lesserArray[j++] = nums[i];
            } else if (nums[i] > pivot) {
                greaterArray[k++] = nums[i];
            } else {
                equalArray[l++] = nums[i];
            }
        }
        int iterator = 0;
        for (int i = 0; i < lesserArray.length; i++) {
            answer[iterator++] = lesserArray[i];
        }
        for (int i = 0; i < equalArray.length; i++) {
            answer[iterator++] = equalArray[i];
        }
        for (int i = 0; i < greaterArray.length; i++) {
            answer[iterator++] = greaterArray[i];
        }
        return answer;
    }
}