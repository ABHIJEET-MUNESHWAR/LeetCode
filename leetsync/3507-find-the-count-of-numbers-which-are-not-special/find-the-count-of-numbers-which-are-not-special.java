class Solution {
    public int nonSpecialCount(int l, int r) {
        int totalNumbers = r - l + 1;
        int specialNumbers = findSpecialNumbers(l, r);
        return totalNumbers - specialNumbers;
    }

    private int findSpecialNumbers(int l, int r) {
        int totalNumbers = r - l + 1;
        int squareRoot = (int) Math.sqrt(r);
        int count = 0;
        List<Integer> primes = findPrimes(squareRoot);
        for (Integer prime : primes) {
            int square = prime * prime;
            if (square >= l && square <= r) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> findPrimes(int limit) {
        boolean[] primes = new boolean[limit + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i <= limit; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) {
                primesList.add(i);
            }
        }
        return primesList;
    }
}