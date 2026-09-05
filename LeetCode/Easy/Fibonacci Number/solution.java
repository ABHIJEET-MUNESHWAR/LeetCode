class Solution {
    public int fib(int n) {
        int a = 0, b = 1, c = 0;
        while (n-- > 0) {
            a = b;
            b = c;
            c = b + a;
        }
        return c;
    }
}