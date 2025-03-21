func mergeArrays(nums1 [][]int, nums2 [][]int) [][]int {
	i, j := 0, 0
	result := [][]int{}
	len1 := len(nums1)
	len2 := len(nums2)
	for i < len1 && j < len2 {
		id1, value1 := nums1[i][0], nums1[i][1]
		id2, value2 := nums2[j][0], nums2[j][1]

		if id1 < id2 {
			result = append(result, []int{id1, value1})
			i++
		} else if id1 > id2 {
			result = append(result, []int{id2, value2})
			j++
		} else {
			result = append(result, []int{id1, value1 + value2})
			i++
			j++
		}
	}
	for i < len1 {
		result = append(result, []int{nums1[i][0], nums1[i][1]})
		i++
	}
	for j < len2 {
		result = append(result, []int{nums2[j][0], nums2[j][1]})
		j++
	}
	return result
}