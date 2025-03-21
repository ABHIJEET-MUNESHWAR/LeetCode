class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder build = new StringBuilder();
        int strLength = s.length();
        int partLength = part.length();
        for (int i = 0; i < strLength; i++) {
            char ch = s.charAt(i);
            build.append(ch);
            int startIndex = build.length() - partLength;
            if (build.length() >= partLength && build.substring(startIndex).equals(part)) {
                int endIndex = build.length();
                build.delete(startIndex, endIndex);
            }
        }
        return build.toString();
    }
}