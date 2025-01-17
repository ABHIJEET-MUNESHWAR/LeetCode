class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = original[i] ^ derived[i];
        }
        if (derived[n - 1] == (original[n - 1] ^ original[0])) {
            return true;
        }
        original[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = original[i] ^ derived[i];
        }
        if (derived[n - 1] == (original[n - 1] ^ original[0])) {
            return true;
        }
        return false;
    }
}