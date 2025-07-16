func maximumLength(nums []int) int {
	n := len(nums)
	evenLen, oddLen := 0, 0
	for _, num := range nums {
		if num%2 == 0 {
			evenLen++
		} else {
			oddLen++
		}
	}
	altLen := 1
	prevParity := nums[0] % 2
	for i := 1; i < n; i++ {
		currParity := nums[i] % 2
		if currParity != prevParity {
			altLen++
			prevParity = currParity
		}
	}
	return max(altLen, evenLen, oddLen)
}