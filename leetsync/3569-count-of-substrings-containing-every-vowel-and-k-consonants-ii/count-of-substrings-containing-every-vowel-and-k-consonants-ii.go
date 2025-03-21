func isVowel(ch byte) bool {
	return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
}
func countOfSubstrings(word string, k int) int64 {
	n := len(word)
	vowelToFreqMap := make(map[byte]int)
	nextConsonent := make([]int, n)
	lastConsonentIndex := n
	for i := n - 1; i >= 0; i-- {
		nextConsonent[i] = lastConsonentIndex
		if !isVowel(word[i]) {
			lastConsonentIndex = i
		}
	}
	left, right, consonentCount, count := 0, 0, 0, 0
	for right < n {
		ch := word[right]
		if isVowel(ch) {
			vowelToFreqMap[ch]++
		} else {
			consonentCount++
		}

		for consonentCount > k {
			ci := word[left]
			if isVowel(ci) {
				vowelToFreqMap[ci]--
				if vowelToFreqMap[ci] == 0 {
					delete(vowelToFreqMap, ci)
				}
			} else {
				consonentCount--
			}
			left++
		}

		for left < n && len(vowelToFreqMap) == 5 && consonentCount == k {
			index := nextConsonent[right]
			count += index - right
			ci := word[left]
			if isVowel(ci) {
				vowelToFreqMap[ci]--
				if vowelToFreqMap[ci] == 0 {
					delete(vowelToFreqMap, ci)
				}
			} else {
				consonentCount--
			}
			left++
		}
		right++
	}
	return int64(count)
}