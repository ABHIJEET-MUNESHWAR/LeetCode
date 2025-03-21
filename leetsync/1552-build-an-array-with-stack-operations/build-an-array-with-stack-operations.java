class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> answer = new ArrayList<>();
        int incomingStream = 1;
        int mismatchCounter = 0;
        int i = 0;
        int size = target.length;
        while ((incomingStream <= n) && (i < size)) {
            if (target[i] == incomingStream) {
                while (mismatchCounter > 0) {
                    answer.add("Pop");
                    mismatchCounter--;
                }
                answer.add("Push");
                i++;
            } else {
                mismatchCounter++;
                answer.add("Push");
            }
            incomingStream++;
        }
        return answer;
    }
}