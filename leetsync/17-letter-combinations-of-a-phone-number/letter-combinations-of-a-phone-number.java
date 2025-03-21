class Solution {

    List<String> result = new ArrayList<>();
    String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        solve(digits, 0, "");
        return result;
    }

    private void solve(String digits, int index, String temp) {
        if (index >= digits.length()) {
            result.add(temp);
            return;
        }
        char ch = digits.charAt(index);
        String str = mapping[ch - '0'];
        for (int i = 0; i < str.length(); i++) {
            String tmp = temp;
            temp += str.charAt(i); // Do
            solve(digits, index + 1, temp); // Explore
            temp = tmp; // Undo
        }
    }
}