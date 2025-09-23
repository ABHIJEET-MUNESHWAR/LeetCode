class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int m = s1.length;
        int n = s2.length;
        int i = 0;
        while (i < m || i < n) {
            int a = i < m ? Integer.parseInt(s1[i]) : 0;
            int b = i < n ? Integer.parseInt(s2[i]) : 0;
            if (a > b) {
                return 1;
            } else if (b > a) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }
}