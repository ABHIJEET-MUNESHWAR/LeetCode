func numOfSubarrays(arr []int) int {
	prefixSum, even, odd, count := 0, 1, 0, 0
	n := len(arr)
	const MOD = 1e9 + 7
	for i := 0; i < n; i++ {
		prefixSum += arr[i]
		if prefixSum%2 == 0 {
			count = (count + odd) % MOD
			even++
		} else {
			count = (count + even) % MOD
			odd++
		}
	}
	return count
}