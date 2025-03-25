func divideArray(nums []int) bool {
	numToFreq := make(map[int]int)
	for _, num := range nums {
		numToFreq[num]++
	}
	for _, value := range numToFreq {
		if value%2 != 0 {
			return false
		}
	}
	return true
}