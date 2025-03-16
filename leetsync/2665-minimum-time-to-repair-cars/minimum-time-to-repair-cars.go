func repairCars(ranks []int, cars int) int64 {
	maxRank := math.MinInt32
	for _, rank := range ranks {
		maxRank = max(maxRank, rank)
	}
	var left int64 = 1
	var right int64 = int64(maxRank * cars * cars)
	var result int64 = 0
	for left <= right {
		mid := int64(left + (right-left)/2)
		if isPossibleToRepair(ranks, cars, mid) {
			result = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return result
}
func isPossibleToRepair(ranks []int, cars int, mid int64) bool {
	var repairdCars int64 = 0
	for _, rank := range ranks {
		repairdCars += int64(math.Sqrt(float64(mid / int64(rank))))
	}
	return repairdCars >= int64(cars)
}