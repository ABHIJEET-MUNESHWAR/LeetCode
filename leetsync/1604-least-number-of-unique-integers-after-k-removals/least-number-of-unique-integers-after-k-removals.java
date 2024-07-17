class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {Map<Integer, Integer> mp = new HashMap<>();

        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            freq.add(entry.getValue());
        }

        Collections.sort(freq);

        for (int i = 0; i < freq.size(); i++) {
            k -= freq.get(i);

            if (k < 0) {
                return freq.size() - i;
            }
        }

        return 0; // All were removed
    }
}