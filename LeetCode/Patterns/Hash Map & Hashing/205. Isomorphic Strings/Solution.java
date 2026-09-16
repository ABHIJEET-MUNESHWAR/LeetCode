class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (Integer i = 0; i < len; i++) {
            if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}