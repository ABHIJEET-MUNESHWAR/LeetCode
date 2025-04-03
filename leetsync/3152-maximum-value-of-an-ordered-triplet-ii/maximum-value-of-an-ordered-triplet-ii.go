func maximumTripletValue(nums []int) int64 {
	maxI, maxDiff, maxResult := 0, 0, 0
	for _, num := range nums {
		maxResult = max(maxResult, (maxDiff * num))
		maxDiff = max(maxDiff, (maxI - num))
		maxI = max(maxI, num)
	}
	return int64(maxResult)
}