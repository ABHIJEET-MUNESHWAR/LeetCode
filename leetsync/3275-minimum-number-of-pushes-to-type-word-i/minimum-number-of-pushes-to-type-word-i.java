class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushCount = 0;
        for (int i = 0; i < n; i++) {
            pushCount += (i / 8) + 1;
        }
        return pushCount;
    }
}