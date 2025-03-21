class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long shift = 0;
        StringBuilder result = new StringBuilder(s);
        int n = shifts.length;
        for (int i = n - 1; i >= 0; i--) {
            int charIntToBeShifted = s.charAt(i) - 'a';
            charIntToBeShifted += (shift + shifts[i]) % 26;
            charIntToBeShifted %= 26;
            char ch = (char) (charIntToBeShifted + 'a');
            result.setCharAt(i, ch);
            shift += shifts[i];
        }
        return result.toString();
    }
}