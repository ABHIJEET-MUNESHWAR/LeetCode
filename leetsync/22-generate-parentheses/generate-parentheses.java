class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solveOne("", n, result);
        return result;
    }

    private void solveOne(String str, int n, List<String> result) {
        if (str.length() == 2 * n) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }
        str += "(";
        solveOne(str, n, result);
        str = str.substring(0, str.length() - 1);

        str += ")";
        solveOne(str, n, result);
    }

    private boolean isValid(String str) {
        int count = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}