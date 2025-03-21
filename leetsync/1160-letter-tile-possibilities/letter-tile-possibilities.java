// Approach-1 (Using simple backtracking Khandani Template)
// T.C : O(n!)
// S.C : O(n * n!), total possible sequences = n! and each having n length
class Solution {
    int n = 0;

    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        Set<String> result = new HashSet<>();
        StringBuilder current = new StringBuilder();
        boolean[] used = new boolean[n];
        solve(tiles, result, current, used);
        return result.size() - 1;// Subtract 1 to exclude the empty sequence
    }

    public void solve(String tiles, Set<String> result, StringBuilder current, boolean[] used) {
        result.add(current.toString());
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            // Do
            // Choose the tile at index i
            current.append(tiles.charAt(i));
            used[i] = true;
            // Explore
            // Explore further with this choice
            solve(tiles, result, current, used);
            // Backtrack: remove the tile and mark it unused
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}