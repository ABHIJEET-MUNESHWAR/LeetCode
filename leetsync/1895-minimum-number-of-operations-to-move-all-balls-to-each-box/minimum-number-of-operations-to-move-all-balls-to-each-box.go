func minOperations(boxes string) []int {
	n := len(boxes)
	answer := make([]int, n)
	cumValue, cumValueSum := 0, 0
	for i := 0; i < n; i++ {
		answer[i] = cumValueSum
		cumValue += int(boxes[i] - '0')
		cumValueSum += cumValue
	}
	cumValue, cumValueSum = 0, 0
	for i := n - 1; i >= 0; i-- {
		answer[i] += cumValueSum
		cumValue += int(boxes[i] - '0')
		cumValueSum += cumValue
	}
	return answer
}