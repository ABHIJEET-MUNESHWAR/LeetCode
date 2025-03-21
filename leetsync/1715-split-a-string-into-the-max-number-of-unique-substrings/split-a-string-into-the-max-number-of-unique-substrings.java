class Solution {
    public int maxUniqueSplit(String s) {
        int currentCount = 0, index = 0;
        int[] maxCount = new int[1]; // Using array to allow updates by reference
        HashSet<String> set = new HashSet<>();
        solve(s, index, currentCount, maxCount, set);
        return maxCount[0];
    }

    public void solve(String s, int index, int currentCount, int[] maxCount, HashSet<String> set) {
        // Pruning for slight improvement
        if (currentCount + (s.length() - index) <= maxCount[0]) {
            return;
        }
        if (index == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currentCount);
            return;
        }
        for (int j = index; j < s.length(); j++) {
            String sub = s.substring(index, j + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                solve(s, j + 1, currentCount + 1, maxCount, set);
                set.remove(sub);
            }
        }

    }
}