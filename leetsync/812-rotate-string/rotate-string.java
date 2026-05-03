class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String contanatedString = s + s;
        return contanatedString.contains(goal);
    }
}