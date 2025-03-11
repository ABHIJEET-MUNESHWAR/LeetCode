func numberOfSubstrings(s string) int {
	n := len(s)
	charToFreqMap := make([]int, 3)
	left, right, count := 0, 0, 0
	for right < n {
		ch := s[right]
		charToFreqMap[ch-'a']++
		for charToFreqMap[0] > 0 && charToFreqMap[1] > 0 && charToFreqMap[2] > 0 {
			count += (n - right)
			charToFreqMap[s[left]-'a']--
			left++
		}
		right++
	}
	return count
}