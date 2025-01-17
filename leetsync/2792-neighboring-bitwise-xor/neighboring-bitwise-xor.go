func doesValidArrayExist(derived []int) bool {
	if checkOriginal(derived, 0) || checkOriginal(derived, 1) {
		return true
	}
	return false
}
func checkOriginal(derived []int, firstValue int) bool {
	n := len(derived)
	original := make([]int, n)
	original[0] = firstValue
	for i := 0; i < n-1; i++ {
		original[i+1] = original[i] ^ derived[i]
	}
	if derived[n-1] == (original[n-1] ^ original[0]) {
		return true
	}
	return false
}