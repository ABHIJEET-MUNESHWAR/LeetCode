class Solution {
    public String sortVowels(String s) {

        int size = s.length();
        int vowelCount = 0;
        String vowels = "aeiouAEIOU";
        char[] result = s.toCharArray();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (vowels.contains(String.valueOf(c))) {
                vowelCount++;
            }
        }
        int[] vowelsArray = new int[vowelCount];
        for (int i = 0, j = 0; i < size; i++) {
            char c = s.charAt(i);
            if (vowels.contains(String.valueOf(c))) {
                vowelsArray[j++] = (int) c;
            }
        }
        Arrays.sort(vowelsArray);
        for (int i = 0, j = 0; i < size; i++) {
            char c = s.charAt(i);
            if (vowels.contains(String.valueOf(c))) {
                result[i] = (char) vowelsArray[j];
                j++;
            } else {
                result[i] = c;
            }
        }
        return new String(result);
    }
}