class Solution {
    public int findComplement(int num) {
        int noOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
        for (int i = 0; i < noOfBits; i++) {
            num = num ^ (1 << i);
        }
        return num;
    }
}