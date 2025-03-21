class SeatManager {
    private PriorityQueue<Integer> pq;
    private int seatMarker;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        seatMarker = 1;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            int seat = pq.poll();
            return seat;
        }
        int seat = seatMarker;
        seatMarker++;
        return seat;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */