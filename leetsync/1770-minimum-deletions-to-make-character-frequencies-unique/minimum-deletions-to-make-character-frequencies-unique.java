class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int result = 0;
        int[] frequencyMap = new int[26];
        for (int i = 0; i < n; i++) {
            frequencyMap[chars[i] - 'a']++;
        }
        Arrays.sort(frequencyMap);
        for (int i = 24; i >= 0 && frequencyMap[i] > 0; i--) {
            if (frequencyMap[i] >= frequencyMap[i + 1]) {
                int previous = frequencyMap[i];
                frequencyMap[i] = Math.max(0, frequencyMap[i + 1] - 1);
                result += (previous - frequencyMap[i]);
            }
        }
        return result;
    }
}