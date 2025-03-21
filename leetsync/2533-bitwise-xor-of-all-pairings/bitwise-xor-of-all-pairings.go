func xorAllNums(nums1 []int, nums2 []int) int {
	m := len(nums1)
	n := len(nums2)
	result := 0
	if m%2 == 1 {
		for _, v := range nums2 {
			result = result ^ v
		}

	}
	if n%2 == 1 {
		for _, v := range nums1 {
			result = result ^ v
		}
	}
	return result
}