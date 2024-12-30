func countGoodStrings(low int, high int, zero int, one int) int {
	const mod = 1_000_000_007
	dp := make([]int, high+1)
	dp[0] = 1
	for i := 1; i < len(dp); i++ {
		if i >= zero {
			dp[i] += dp[i-zero]
		}
		if i >= one {
			dp[i] += dp[i-one]
		}
		dp[i] %= mod
	}
	result := 0
	for i := low; i <= high; i++ {
		result += dp[i]
		result %= mod
	}
	return result
}