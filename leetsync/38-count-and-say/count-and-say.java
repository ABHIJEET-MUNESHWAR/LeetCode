class Solution {
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);

        int size = say.length();
        String result = "";
        for (int i = 0; i < size; i++) {
            char ch = say.charAt(i);
            int count = 1;
            while ((i + 1 < size) && (say.charAt(i) == say.charAt(i + 1))) {
                count++;
                i++;
            }
            result += count + "" + ch;
        }
        return result;
    }
}