class Solution {
    public char dfsToFindMin(Map<Character, List<Character>> adjListMap, char ch, boolean[] visited) {
        visited[ch - 'a'] = true;
        char minChar = ch;
        List<Character> neighbours = adjListMap.getOrDefault(ch, new ArrayList<>());
        for (char neighbour : neighbours) {
            if (!visited[neighbour - 'a']) {
                char nextChar = dfsToFindMin(adjListMap, neighbour, visited);
                if (minChar > nextChar) {
                    minChar = nextChar;
                }
            }
        }
        return minChar;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        Map<Character, List<Character>> adjListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            adjListMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjListMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            result.append(dfsToFindMin(adjListMap, ch, visited));
        }
        return result.toString();
    }
}