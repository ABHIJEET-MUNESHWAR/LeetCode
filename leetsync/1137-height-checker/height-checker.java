class Solution {
    public int heightChecker(int[] heights) {

    int mismatch = 0;
    int size = heights.length;
    int[] sortedHeight = new int[size];
    for (int i = 0; i < size; i++) {
      sortedHeight[i] = heights[i];
    }
    Arrays.sort(sortedHeight);
    for (int i = 0; i < size; i++) {
      if (sortedHeight[i] != heights[i]) {
        mismatch++;
      }
    }
    return mismatch;        
    }
}