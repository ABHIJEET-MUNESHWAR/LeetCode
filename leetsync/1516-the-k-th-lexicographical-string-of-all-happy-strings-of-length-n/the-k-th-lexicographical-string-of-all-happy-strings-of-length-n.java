class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backTrack(n, k, result, current, 0);
        for (String res : result) {
            System.out.println(res);
        }
        if (k > result.size()) {
            return "";
        }
        return result.get(k - 1);
    }

    public void backTrack(int n, int k, List<String> result, StringBuilder current, int index) {
        if (index >= n) {
            result.add(current.toString());
            return;
        }
        for (char ch = 'a'; ch < 'd'; ch++) {
            // Check previous element
            if (!current.isEmpty() && current.charAt(current.length() - 1) == ch) {
                continue;
            }
            // Do
            current.append(ch);
            // Explore
            backTrack(n, k, result, current, index + 1);
            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}