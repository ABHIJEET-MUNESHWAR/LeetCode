func checkIfExist(arr []int) bool {
	dict := map[int]bool{}
	for _, v := range arr {
		if dict[2*v] || (dict[v/2] && v%2 == 0) {
			return true
		}
		dict[v] = true
	}
	return false
}