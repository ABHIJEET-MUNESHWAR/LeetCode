func minimumIndex(nums []int) int {
	n := len(nums)
	majorityElement := findMajorityElement(nums)

	majorityElementCount := 0

	for _, num := range nums {
		if num == majorityElement {
			majorityElementCount++
		}
	}

	count := 0

	for i, num := range nums {
		if num == majorityElement {
			count++
		}
		remainingCount := majorityElementCount - count
		n1 := i + 1
		n2 := n - i - 1
		if (count > (n1 / 2)) && (remainingCount > (n2 / 2)) {
			return i
		}
	}
	return -1
}
func findMajorityElement(nums []int) int {
	count := 0
	majorityElement := -1
	for _, num := range nums {
		if count == 0 {
			majorityElement = num
			count = 1
		} else if majorityElement == num {
			count++
		} else {
			count--
		}
	}
	return majorityElement
}