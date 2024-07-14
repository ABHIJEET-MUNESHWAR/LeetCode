class Solution {
    public int minDeletions(String s) {        
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] frequencyMap = new int[26];
        int result = 0;
        for (int i = 0; i < n; i++) {
            frequencyMap[chars[i] - 'a']++;
        }
        Set<Integer> frequencySet = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (frequencyMap[i] > 0 && frequencySet.contains(frequencyMap[i])) {
                frequencyMap[i]--;
                result++;
            }
            frequencySet.add(frequencyMap[i]);
        }
        return result;
    }
}