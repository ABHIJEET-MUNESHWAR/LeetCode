class Solution {
    public int findComplement(int num) {
        int noOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << noOfBits) - 1;
        return (num ^ mask);
    }
}