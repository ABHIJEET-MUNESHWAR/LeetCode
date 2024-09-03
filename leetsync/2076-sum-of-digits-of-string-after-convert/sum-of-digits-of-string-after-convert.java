class Solution {
    public int getLucky(String s, int k) {
        StringBuilder number = new StringBuilder();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            number.append(ch - 'a' + 1);
        }
        int sum = 0;
        while (k-- > 0) {
            sum = 0;
            for (char ch : number.toString().toCharArray()) {
                sum += ch - '0';
            }
            number = new StringBuilder(Integer.toString(sum));
        }
        return Integer.parseInt(number.toString());
    }
}