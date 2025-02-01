func isArraySpecial(nums []int) bool {
	n := len(nums)
	isEven := nums[0]%2 == 0
	for i := 1; i < n; i++ {
		isEven = !isEven
		currentParity := nums[i]%2 == 0
		if currentParity != isEven {
			return false
		}
	}
	return true
}