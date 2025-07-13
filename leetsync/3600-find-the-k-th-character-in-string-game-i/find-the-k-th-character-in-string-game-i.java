class Solution {
    public char kthCharacter(int k) {
        int shift = Integer.bitCount(k - 1);
        return (char) ('a' + shift);
    }
}