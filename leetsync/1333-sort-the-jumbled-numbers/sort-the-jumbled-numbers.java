class Solution {
    class Pair {
        int mappedNumber;
        int originalIndex;

        public Pair(int mappedNumber, int originalIndex) {
            this.mappedNumber = mappedNumber;
            this.originalIndex = originalIndex;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String numberString = Integer.toString(nums[i]);
            String mappedString = getMappedNumber(numberString, mapping);
            int mappedNumber = Integer.parseInt(mappedString);
            pairs.add(new Pair(mappedNumber, i));
        }
        Collections.sort(pairs, (a, b) -> a.mappedNumber - b.mappedNumber);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = pairs.get(i).originalIndex;
            result[i] = nums[originalIndex];
        }
        return result;
    }

    private String getMappedNumber(String numberString, int[] mapping) {
        StringBuilder mappedNumber = new StringBuilder();
        for (char ch : numberString.toCharArray()) {
            mappedNumber.append(mapping[ch - '0']);
        }
        return mappedNumber.toString();
    }
}