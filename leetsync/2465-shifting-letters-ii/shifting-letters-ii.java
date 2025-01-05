class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n]; // Difference array with size n
        // Step 1: Populate the difference array
        for (int[] shift : shifts) {
            int left = shift[0];
            int right = shift[1];
            int direction = shift[2];
            int shiftCount = 1;
            if (direction == 0) {
                shiftCount = -1;
            }
            diff[left] += shiftCount;
            if (right + 1 < n) {
                diff[right + 1] -= shiftCount;
            }
        }
        // Step 2: Compute the prefix sum to get the net shifts for each character
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        // Step 3: Apply the shifts to the string
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26; // Ensure shift is within the range [0, 25]
            if (shift < 0) {
                shift += 26; // Handle negative shifts (backward)
            }
            // Apply the shift to character
            int chInt = s.charAt(i) - 'a';
            sb.setCharAt(i, (char) ((shift + chInt) % 26 + 'a'));
        }
        return sb.toString();
    }
}