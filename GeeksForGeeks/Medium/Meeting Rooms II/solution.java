class Solution {
	public int minMeetingRooms(int[] start, int[] end) {
		// code here
		List<int[]> events = new ArrayList<>();
		int n = start.length;
		for (int i = 0; i<n; i++) {
			events.add(new int[] {start[i], 1});
			events.add(new int[] {end[i], -1});
		}
		events.sort((a, b)->a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);
		int currentRooms = 0, maxRooms = 0;
		for (int[] event: events) {
			currentRooms += event[1];
			maxRooms = Math.max(maxRooms, currentRooms);
		}
		return maxRooms;
	}
}
