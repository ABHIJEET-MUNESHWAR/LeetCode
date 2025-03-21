class Solution {
    public boolean[] sieveHelper(int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= right; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveHelper(right);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                primes.add(num);
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int[] result = { -1, -1 };

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }
}