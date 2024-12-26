func findTargetSumWays(nums []int, target int) int {
	return solve(nums, target, 0, 0)
}

func solve(nums []int, target int, index int, currentSum int) int {
	if index == len(nums) {
		if currentSum == target {
			return 1
		} else {
			return 0
		}
	}
	plus := solve(nums, target, index+1, currentSum+nums[index])
	minus := solve(nums, target, index+1, currentSum-nums[index])
	return plus + minus
}