class Solution {
    public String[] divideString(String s, int k, char fill) {
        while (s.length() % k != 0) {
            s += fill;
        }
        int n = s.length();
        String[] result = new String[n / k];
        int i = 0, index = 0;
        while (i < n) {
            result[index++] = s.substring(i, i + k);
            i += k;
        }
        return result;
    }
}