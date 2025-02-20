func findDifferentBinaryString(nums []string) string {
	answer := make([]byte, len(nums[0]))
	for index, value := range nums {
		ch := value[index]
		if ch == '0' {
			answer[index] = '1'
		} else {
			answer[index] = '0'
		}
	}
	return string(answer)
}