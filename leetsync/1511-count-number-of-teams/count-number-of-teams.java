class Solution {
    public int numTeams(int[] rating) {

        int count = 0;
        int n = rating.length;
        // count for ascending sequence
        for (int j = 0; j < n; j++) {
            int smallerNumbers = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    smallerNumbers++;
                }
            }
            int largerNumbers = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    largerNumbers++;
                }
            }
            count += smallerNumbers * largerNumbers;
        }

        // count for descending sequence
        for (int j = n - 1; j >= 0; j--) {
            int largerNumbers = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] > rating[j]) {
                    largerNumbers++;
                }
            }
            int smallerNumbers = 0;
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    smallerNumbers++;
                }
            }
            count += smallerNumbers * largerNumbers;
        }
        return count;
    }
}