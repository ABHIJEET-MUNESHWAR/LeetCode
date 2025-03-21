func addSpaces(s string, spaces []int) string {
	result := make([]uint8, 0, len(s)+len(spaces))

	for sIterator, spaceIterator := 0, 0; sIterator < len(s); sIterator++ {
		if spaceIterator < len(spaces) && sIterator == spaces[spaceIterator] {
			result = append(result, ' ')
			spaceIterator++
		}
		result = append(result, s[sIterator])
	}
	return string(result)
}