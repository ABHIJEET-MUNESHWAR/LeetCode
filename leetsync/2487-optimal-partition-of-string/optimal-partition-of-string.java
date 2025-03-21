class Solution {
    public int partitionString(String s) {

        int partitionCount = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                partitionCount++;
                set.clear();
                set.add(c);
            } else {
                set.add(c);
            }
        }
        return ++partitionCount;
    }
}