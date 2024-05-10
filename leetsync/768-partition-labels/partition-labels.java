class Solution {
    public List<Integer> partitionLabels(String s) {

        int size = s.length();
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> occuranceMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            occuranceMap.put(c, i);
        }
        int currentPartitionSize = 0;
        int currentEnd = 0;
        int end = 0;
        for (int i = 0; i < size; i++) {
            currentPartitionSize++;
            char c = s.charAt(i);
            currentEnd = occuranceMap.get(c);
            end = Math.max(end, currentEnd);
            if (i == end) {
                answer.add(currentPartitionSize);
                currentPartitionSize = 0;
            }
        }
        return answer;
    }
}