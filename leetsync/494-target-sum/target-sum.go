var totalSum = 0

func findTargetSumWays(nums []int, target int) int {
	for _, val := range nums {
		totalSum += val
	}
	memo := make([][]int, len(nums))
	for index := range memo {
		memo[index] = make([]int, totalSum*2+1)
		for index2 := range memo[index] {
			memo[index][index2] = -1
		}
	}
	currentSum := 0
	return solve(nums, target, 0, currentSum, &memo)
}

func solve(nums []int, target int, index int, currentSum int, memo *[][]int) int {
	if index == len(nums) {
		if currentSum == target {
			return 1
		} else {
			return 0
		}
	}
	if (*memo)[index][totalSum+currentSum] != -1 {
		return (*memo)[index][totalSum+currentSum]
	}
	plus := solve(nums, target, index+1, currentSum+nums[index], memo)
	minus := solve(nums, target, index+1, currentSum-nums[index], memo)
	(*memo)[index][totalSum+currentSum] = plus + minus
	return (*memo)[index][totalSum+currentSum]
}