class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> ballToColorMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> colorToFreqMap = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];
            if(ballToColorMap.containsKey(ball)){
                int previousColor = ballToColorMap.get(ball); // already colored ball
                colorToFreqMap.put(previousColor, colorToFreqMap.get(previousColor)-1);
                if(colorToFreqMap.get(previousColor)==0){
                    colorToFreqMap.remove(previousColor);
                }
            }
            ballToColorMap.put(ball, color);
            colorToFreqMap.put(color, colorToFreqMap.getOrDefault(color, 0)+1);
            result[i] = colorToFreqMap.size();
        }
        return result;
    }
}