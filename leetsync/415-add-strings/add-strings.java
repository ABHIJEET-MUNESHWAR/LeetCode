class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
        }
        return sb.reverse().toString();
    }
}