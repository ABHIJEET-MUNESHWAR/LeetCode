class Solution {
    public boolean checkStrings(String s1, String s2) {
        long eX = 0, oX = 0, eS = 0, oS = 0;

        for (int i = 0; i < s1.length(); i++) {
            int v1 = s1.charAt(i), v2 = s2.charAt(i);
            int dx = v1 ^ v2;
            int ds = v1 * v1 - v2 * v2;

            if ((i & 1) == 1) {
                oX ^= dx;
                oS += ds;
            } else {
                eX ^= dx;
                eS += ds;
            }
        }

        return (eX | oX | eS | oS) == 0;
    }
}