class Solution {
    public int minCostToMoveChips(int[] positions) {

    int oddParity = 0, evenParity = 0;
    for (int position : positions) {
      if (position % 2 == 0) {
        evenParity++;
      } else {
        oddParity++;
      }
    }
    return Math.min(oddParity, evenParity);        
    }
}