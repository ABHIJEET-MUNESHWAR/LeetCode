class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int stepsLength = s.length();
        int[] result = new int[stepsLength];
        for (int i = 0; i < stepsLength; i++) {
            int currentRow = startPos[0];
            int currentCol = startPos[1];
            int totalMoves = 0;
            for (int j = i; j < stepsLength; j++) {
                char currentMove = s.charAt(j);
                switch (currentMove) {
                    case 'R':
                        currentCol++;
                        break;
                    case 'L':
                        currentCol--;
                        break;
                    case 'U':
                        currentRow--;
                        break;
                    case 'D':
                        currentRow++;
                        break;
                }
                if (currentCol < 0 || currentCol >= n || currentRow < 0 || currentRow >= n) {
                    break;
                } else {
                    totalMoves++;
                }
            }
            result[i] = totalMoves;
        }
        return result;
    }
}