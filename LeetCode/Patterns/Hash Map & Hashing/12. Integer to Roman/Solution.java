class Solution {
    public String intToRoman(int num) {
        final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        final String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            if (num == 0) {
                break;
            }
            int times = num / values[i];
            while (times-- > 0) {
                sb.append(symbols[i]);
            }
            num = num % values[i];
        }
        return sb.toString();
    }
}