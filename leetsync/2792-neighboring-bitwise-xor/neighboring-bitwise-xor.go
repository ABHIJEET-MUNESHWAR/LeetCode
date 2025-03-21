func doesValidArrayExist(derived []int) bool {
	xor := 0
	for _, value := range derived {
		xor = xor ^ value
	}
	return xor == 0
}