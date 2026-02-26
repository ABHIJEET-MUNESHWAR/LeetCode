class Solution {
    public int numSteps(String s) {
        int size = s.length();
        int steps = 0;
        int carry = 0;
        for (int i = size - 1; i > 0; i--) {
            int currentDigit = (s.charAt(i) - '0') + carry;
            if (currentDigit % 2 == 1) { // Odd
                carry = 1;
                steps += 2;
            } else { // Even
                steps++;
            }
        }
        return steps + carry;
    }
}