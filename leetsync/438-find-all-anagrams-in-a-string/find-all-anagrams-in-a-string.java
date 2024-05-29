class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> answer = new ArrayList<>();
        int sourceSize = s.length();
        int patternSize = p.length();
        int[] patternFrequency = setPatternFrequency(p);
        int left = 0, right = 0;
        while (right < sourceSize) {
            // patternFrequency[s.charAt(right) - 'a']++;
            right++;
            if ((right - left) == patternSize) {
                if (Arrays.equals(patternFrequency, setPatternFrequency(s.substring(left, right)))) {
                    answer.add(left);
                }
                // patternFrequency[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return answer;
    }

    public int[] setPatternFrequency(String pattern) {
        int[] patternFrequency = new int[26];
        for (char c : pattern.toCharArray()) {
            patternFrequency[c - 'a']++;
        }
        return patternFrequency;
    }
}