class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxConversions = 0;
        int size = s.length();
        int i = 0, j = 0;
        int currentCost = 0;
        while (i < size && j < t.length()) {
            currentCost += Math.abs(s.charAt(j) - t.charAt(j));
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++; // Shrink window from left side
            }
            maxConversions = Math.max(maxConversions, j - i + 1);
            j++;
        }
        return maxConversions;
    }
}