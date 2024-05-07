class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] extractedNums = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(extractedNums);
            int diff = extractedNums[1] - extractedNums[0];
            boolean isDiffSame = true;
            for (int j = 1; j < extractedNums.length; j++) {
                int intermediateDiff = extractedNums[j] - extractedNums[j - 1];
                if (intermediateDiff != diff) {
                    isDiffSame = false;
                    break;
                }
            }
            result.add(isDiffSame);
        }
        return result;
    }
}