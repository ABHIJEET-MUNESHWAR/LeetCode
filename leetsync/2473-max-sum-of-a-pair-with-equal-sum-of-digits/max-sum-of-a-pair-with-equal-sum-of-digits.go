func maximumSum(nums []int) int {
	digitSumToNumMap := [82]int{}
	maxSum := -1
	for _, num := range nums {
		digitSum := getDigitSum(num)
		value := digitSumToNumMap[digitSum]
		if value > 0 {
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