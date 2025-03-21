class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solveOptimised("", n, result, 0, 0);
        return result;
    }

    private void solveOptimised(String str, int n, List<String> result, int open, int close) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) {
            str += "(";
            solveOptimised(str, n, result, open + 1, close);
            str = str.substring(0, str.length() - 1);
        }
        if (close < open) {
            str += ")";
            solveOptimised(str, n, result, open, close + 1);
            str = str.substring(0, str.length() - 1);
        }
    }
}