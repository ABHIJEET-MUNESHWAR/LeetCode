class Solution {
    String[] numToStrMap = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> combinations = new ArrayList<>();

    public void letterCombinationsBackTrack(String digits, int n, String currentString, int index) {
        if (index >= n) {
            combinations.add(currentString);
            return;
        }
        char ch = digits.charAt(index);
        String buttonString = numToStrMap[ch - '0'];
        int length = buttonString.length();
        for (int i = 0; i < length; i++) {
            String temp = currentString;
            currentString += buttonString.charAt(i);
            letterCombinationsBackTrack(digits, n, currentString, index + 1);
            currentString = temp;
        }
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return combinations;
        }
        letterCombinationsBackTrack(digits, n, "", 0);
        return combinations;
    }
}