class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        int[] letterToFrequencyMap = new int[26];
        for (int i = 0; i < n; i++) {
            letterToFrequencyMap[word.charAt(i) - 'a'] = 1;
        }
        Integer[] mpInteger = Arrays.stream(letterToFrequencyMap).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());
        for (int i = 0; i < 26; i++) {
            int frequency = mpInteger[i];
            int press = (i / 8) + 1;
            result += frequency * press;
        }
        return result;
    }
}