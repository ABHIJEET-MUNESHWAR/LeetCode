class Solution {
    List<String> combinations = new ArrayList<>();
    String[] numToStrMap = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return combinations;
        }
        backtrack(digits, n, "", 0);
        return combinations;
    }

    public void backtrack(String digits, int n, String currentString, int index) {
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
            backtrack(digits, n, currentString, index + 1);
            currentString = temp;
        }
    }
}