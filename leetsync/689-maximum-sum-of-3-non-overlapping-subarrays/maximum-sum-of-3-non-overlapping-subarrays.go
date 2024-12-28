func maxSumOfThreeSubarrays(nums []int, k int) []int {
	n := len(nums)
	prefixSum := make([]int, n+1)
	for i := 0; i < n; i++ {
		prefixSum[i+1] = prefixSum[i] + nums[i]
	}
	leftMaxIndex := make([]int, n)
	for i, currentMaxSum := k, prefixSum[k]-prefixSum[0]; i < n; i++ {
		sum := prefixSum[i+1] - prefixSum[i+1-k]
		if sum > currentMaxSum {
			leftMaxIndex[i] = i + 1 - k
			currentMaxSum = sum
		} else {
			leftMaxIndex[i] = leftMaxIndex[i-1]
		}
	}
	rightMaxIndex := make([]int, n)
	rightMaxIndex[n-k] = n - k
	for i, currentMaxSum := n-k-1, prefixSum[n]-prefixSum[n-k]; i >= 0; i-- {
		if prefixSum[i+k]-prefixSum[i] >= currentMaxSum {
			rightMaxIndex[i] = i
			currentMaxSum = prefixSum[i+k] - prefixSum[i]
		} else {
			rightMaxIndex[i] = rightMaxIndex[i+1]
		}
	}
	ans := []int{}
	maxSum := 0
	for i := k; i <= n-2*k; i++ {
		left := leftMaxIndex[i-1]
		right := rightMaxIndex[i+k]
		totalSum :=
			prefixSum[i+k] - prefixSum[i] +
				prefixSum[left+k] - prefixSum[left] +
				prefixSum[right+k] - prefixSum[right]

		if totalSum > maxSum {
			maxSum = totalSum
			ans = []int{left, i, right}
		}
	}
	return ans

}