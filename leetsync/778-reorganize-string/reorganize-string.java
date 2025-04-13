class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqToCharMap = new HashMap<>();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            int freq = freqToCharMap.getOrDefault(ch, 0) + 1;
            if (freq > ((n + 1) / 2)) {
                return "";
            }
            freqToCharMap.put(ch, freq);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> entry : freqToCharMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            pq.add(new int[] { freq, ch });
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char) first[1]);
            sb.append((char) second[1]);
            first[0]--;
            second[0]--;
            if (first[0] > 0) {
                pq.add(first);
            }
            if (second[0] > 0) {
                pq.add(second);
            }
        }
        if (!pq.isEmpty()) {
            int[] first = pq.poll();
            sb.append((char) first[1]);
        }
        return sb.toString();
    }
}