class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n + k - 1;
        int[] extended = new int[N];
        System.arraycopy(colors, 0, extended, 0, n);
        for (int i = 0; i < k - 1; i++) {
            extended[n + i] = colors[i]; // to handle wrap-around (circular array)
        }
        int result = 0;
        int left = 0, right = 1; // because we have to check index right-1 for checking alternate
        while (right < N) {
            if (extended[right] == extended[right - 1]) {
                left = right;
                right++;
                continue;
            }
            if (right - left + 1 == k) {
                result++;
                left++;
            }
            right++;
        }
        return result;
    }
}