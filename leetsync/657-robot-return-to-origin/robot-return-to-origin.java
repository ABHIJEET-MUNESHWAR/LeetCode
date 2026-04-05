class Solution {
    public boolean judgeCircle(String moves) {

        int l = 0, r = 0, u = 0, d = 0;
        char[] movesCharArray = moves.toCharArray();
        for (char move : movesCharArray) {
            switch (move) {
                case 'U':
                    u++;
                    break;
                case 'D':
                    d++;
                    break;
                case 'L':
                    l++;
                    break;
                case 'R':
                    r++;
                    break;
            }
        }
        return (l == r) && (u == d);
    }
}