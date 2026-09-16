class Solution {
    public boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = getDigitSquareSum(slow);
      fast = getDigitSquareSum(fast);
      fast = getDigitSquareSum(fast);
    } while (slow != fast);
    if (slow == 1) {
      return true;
    } else {
      return false;
    }
  }

  private int getDigitSquareSum(int n) {
    int sum = 0;
    while (n > 0) {
      int mod = n % 10;
      sum += mod * mod;
      n = n / 10;
    }
    return sum;
  }
}