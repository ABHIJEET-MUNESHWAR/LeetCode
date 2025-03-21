type minHeap []*numsIndex

type numsIndex struct {
	nums  []int
	index int
}

func (h minHeap) Len() int {
	return len(h)
}

func (h minHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h minHeap) Less(i, j int) bool {
	return h[i].nums[h[i].index] < h[j].nums[h[j].index] ||
		(h[i].nums[h[i].index] == h[j].nums[h[j].index] && h[i].index < h[j].index)
}

func (h *minHeap) Push(obj any) {
	*h = append(*h, obj.(*numsIndex))
}

func (h *minHeap) Pop() any {
	old := *h
	length := len(old)
	element := old[length-1]
	*h = old[:length-1]
	return element
}

func getFinalState(nums []int, k int, multiplier int) []int {
	var arrIndexNums = make(minHeap, 0, len(nums))
	for i := 0; i < len(nums); i++ {
		arrIndexNums = append(arrIndexNums, &numsIndex{nums, i})
	}
	heap.Init(&arrIndexNums)

	for i := 0; i < k; i++ {
		arrIndexNums[0].nums[arrIndexNums[0].index] *= multiplier
		heap.Fix(&arrIndexNums, 0)
	}
	return nums
}