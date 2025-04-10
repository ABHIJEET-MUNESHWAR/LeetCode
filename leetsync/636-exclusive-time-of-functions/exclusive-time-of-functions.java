class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int lastLogTimeStamp = 0;
        int[] result = new int[n];
        for (String log : logs) {
            String[] str = log.split(":");
            int functionId = Integer.parseInt(str[0]);
            boolean isStart = str[1].equals("start");
            int timestamp = Integer.parseInt(str[2]);
            if (!isStart) {
                timestamp++;
            }
            if (!stack.isEmpty()) {
                int funcId = stack.peek();
                result[funcId] += timestamp - lastLogTimeStamp;
            }
            if (isStart) {
                stack.push(functionId);
            } else {
                stack.pop();
            }
            lastLogTimeStamp = timestamp;
        }
        return result;
    }
}