func longestSubsequence(s string, k int) int {
	n := len(s)
	maxLength := 0
	powerValue := 1
	for i := n - 1; i >= 0; i-- {
		if s[i] == '0' {
			maxLength++
		} else if powerValue <= k {
			maxLength++
			k -= powerValue
		}
		if powerValue <= k {
			powerValue *= 2
		}
	}
	return maxLength
}