func maxChunksToSorted(arr []int) int {
	n := len(arr)
	chunksCount, maxTillNow := 0, 0
	for i := 0; i < n; i++ {
		if maxTillNow < arr[i] {
			maxTillNow = arr[i]
		}
		if maxTillNow == i {
			chunksCount++
		}
	}
	return chunksCount
}