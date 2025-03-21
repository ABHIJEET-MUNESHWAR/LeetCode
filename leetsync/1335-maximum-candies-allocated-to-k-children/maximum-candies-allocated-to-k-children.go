func maximumCandies(candies []int, k int64) int {
	var total int64 = 0
	maxCandy := 0
	for _, candy := range candies {
		maxCandy = max(maxCandy, candy)
		total += int64(candy)
	}
	if total < k {
		return 0
	}
	left, right, result := 1, maxCandy, 0
	for left <= right {
		mid := left + (right-left)/2
		if canDistribute(candies, k, mid) {
			left = mid + 1
			result = mid
		} else {
			right = mid - 1
		}
	}
	return result
}

func canDistribute(candies []int, k int64, mid int) bool {
	n := len(candies)
	for i := 0; i < n; i++ {
		k -= int64(candies[i] / mid)
		if k <= 0 {
			return true
		}
	}
	return k <= 0
}