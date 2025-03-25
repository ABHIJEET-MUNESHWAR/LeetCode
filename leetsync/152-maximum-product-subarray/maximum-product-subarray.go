func maxProduct(nums []int) int {
	n := len(nums)
	prefix, suffix, maxProduct := 1, 1, nums[0]
	for i := 0; i < n; i++ {
		j := n - i - 1
		if prefix == 0 {
			prefix = 1
		}
		if suffix == 0 {
			suffix = 1
		}
		prefix *= nums[i]
		suffix *= nums[j]
		maxProduct = max(maxProduct, max(prefix, suffix))
	}
	return maxProduct
}