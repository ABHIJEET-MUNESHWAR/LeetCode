class Solution {
    List<String> combinations = new ArrayList<>();
    String[] numToStrMap = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        solve(digits, 0, "");
        return combinations;
    }

    public void solve(String digits, int index, String temp) {
        if (index >= digits.length()) {
            combinations.add(temp);
            return;
        }
        char ch = digits.charAt(index);
        String str = numToStrMap[ch - '0'];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String tmp = temp;
            temp += str.charAt(i); // Do
            solve(digits, index + 1, temp); // Explore
            temp = tmp; // Undo
        }
    }
}