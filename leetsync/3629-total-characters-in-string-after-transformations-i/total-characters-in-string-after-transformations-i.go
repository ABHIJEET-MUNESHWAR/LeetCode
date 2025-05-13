func lengthAfterTransformations(s string, t int) int {
	const mod int = 1000000007
	mp := make([]int, 26)
	for _, ch := range s {
		mp[ch-'a']++
	}
	for c := 0; c < t; c++ {
		temp := make([]int, 26)
		for i := 0; i < 26; i++ {
			ch := i + 'a'
			freq := mp[i]
			if ch != 'z' {
				temp[(ch+1)-'a'] = (temp[(ch+1)-'a'] + freq) % mod
			} else {
				temp['a'-'a'] = (temp['a'-'a'] + freq) % mod
				temp['b'-'a'] = (temp['b'-'a'] + freq) % mod
			}
		}
		mp = temp
	}
	result := 0
	for i := 0; i < 26; i++ {
		result = (result + mp[i]) % mod
	}
	return result
}