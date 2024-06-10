class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder build = new StringBuilder();
        int stringLength = s.length();
        int partLength = part.length();
        for (int i = 0; i < stringLength; i++) {
            build.append(s.charAt(i));
            int startIndex = build.length() - partLength;
            if (build.length() >= partLength && build.substring(startIndex).equals(part)) {
                int endIndex = build.length();
                build.delete(startIndex, endIndex);
            }
        }
        return build.toString();
    }
}