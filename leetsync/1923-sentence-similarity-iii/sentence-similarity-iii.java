class Solution {

    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
        Deque<String> dq1 = new LinkedList<>(Arrays.asList(s1.split(" ")));
        Deque<String> dq2 = new LinkedList<>(Arrays.asList(s2.split(" ")));

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekFirst().equals(dq2.peekFirst())) {
            dq1.pollFirst();
            dq2.pollFirst();
        }

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq2.isEmpty();
    }
}