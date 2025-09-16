class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            while (!result.isEmpty()) {
                int prev = result.get(result.size() - 1);
                int gcd = gcd(prev, num);
                if (gcd == 1) {
                    break;
                }
                result.remove(result.size() - 1);
                long lcm = (long) prev / gcd * num;
                num = (int) lcm;
            }
            result.add(num);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}