class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            // Skip underscores in the start string
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            // Skip underscores in the target string
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            // Check if both pointers have reached the end
            if (i == n || j == n) {
                return i == n && j == n;
            }
            // If the characters at i and j are different, transformation is not possible
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            // Check for invalid moves
            if (start.charAt(i) == 'L' && i < j) {
                return false;// 'L' can't move to the right
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;// 'R' can't move to the left
            }
            // Move both pointers forward
            i++;
            j++;
        }
        return true;
    }
}