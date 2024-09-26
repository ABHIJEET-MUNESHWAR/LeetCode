class MyCalendar {

    // TreeSet to store the booked intervals
    TreeSet<int[]> st;

    public MyCalendar() {
        // Initialize the TreeSet with a custom comparator
        st = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    }

    public boolean book(int start, int end) {
        // Find the first event that starts after or at the same time of {start, end}
        int[] event = new int[]{start, end};
        int[] next = st.ceiling(event); // O(logN)

        // Check if the current event overlaps with the next event
        if (next != null && next[0] < end) {
            return false;
        }

        // Check if the current event overlaps with the previous event
        int[] prev = st.floor(event);
        if (prev != null && start < prev[1]) {
            return false;
        }

        // If no overlap, add the booking to the set
        st.add(new int[]{start, end});
        return true;
    }
}