class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : arr) {
            for (int x : prev) {
                curr.add(x | num);
                result.add(x | num);
            }
            curr.add(num);
            result.add(num);
            prev = curr;
            curr = new HashSet<>();
        }
        return result.size();
    }
}