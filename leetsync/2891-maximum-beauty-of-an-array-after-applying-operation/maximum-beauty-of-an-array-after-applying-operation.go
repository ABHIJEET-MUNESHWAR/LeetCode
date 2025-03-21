package main

import (
	"sort"
)

func maximumBeauty(nums []int, k int) int {
	maxBeauty, i, j := 0, 0, 0
	sort.Ints(nums)
	n := len(nums)
	for i < n {
		for j < n && ((nums[j] - nums[i]) <= (2 * k)) {
			j++
		}
		if maxBeauty < (j - i) {
			maxBeauty = j - i
		}
		i++
	}
	return maxBeauty
}
