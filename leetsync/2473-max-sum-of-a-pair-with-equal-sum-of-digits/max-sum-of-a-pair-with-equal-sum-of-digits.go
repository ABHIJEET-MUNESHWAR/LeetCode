func maximumSum(nums []int) int {
	digitSumToNumMap := make(map[int]int)
	maxSum := -1
	for _, num := range nums {
		digitSum := getDigitSum(num)
		value, ok := digitSumToNumMap[digitSum]
		if ok {
			maxSum = max(maxSum, num+value)
		} else {
			value = 0
		}
		digitSumToNumMap[digitSum] = max(num, value)
	}
	return maxSum
}

func getDigitSum(num int) int {
	sum := 0
	for num > 0 {
		sum = sum + num%10
		num = num / 10
	}
	return sum
}