class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int length = names.length;
        String[] ans = new String[length];
        Map<Integer, String> heightToNamesMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            heightToNamesMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for (int i = length - 1, j = 0; i >= 0; i--) {
            ans[j++] = heightToNamesMap.get(heights[i]);
        }
        return ans;
    }
}