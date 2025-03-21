class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int[][] matrix = new int[26][n + 1];// Matrix to store counts for each character and length
        char prevChar = s.charAt(0);
        int length = 0;
        // Populate the matrix
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (currChar == prevChar) {
                length++;
                matrix[currChar - 'a'][length]++;
            } else {
                length = 1;
                matrix[currChar - 'a'][length]++;
                prevChar = currChar;
            }
        }
        int result = 0;
        // Calculate the result by checking cumulative sums in reverse order
        for (int i = 0; i < 26; i++) {
            int cumSum = 0;
            for (int j = n; j > 0; j--) {
                cumSum += matrix[i][j];
                if (cumSum >= 3) {
                    result = Math.max(result, j);
                    break;
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}