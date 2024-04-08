class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();
        int top = 0, count = 0;
        for (int i = 0; i < students.length; i++) {
            queue.add(students[i]);
        }
        while (!queue.isEmpty() && count != queue.size()) {
            if (sandwiches[top] == queue.peek()) {
                count = 0;
                queue.poll();
                top++;
            } else {
                count++;
                queue.add(queue.poll());
            }
        }
        return queue.size();
    }
}