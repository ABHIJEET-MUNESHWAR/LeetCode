func findScore(nums []int) int64 {
	elements := make([]element, len(nums))
	for i := 0; i < len(nums); i++ {
		elements[i] = element{
			value: nums[i],
			index: i,
		}
	}
	// use a map to check whether an element has been marked
	marked := make(map[int]bool)
	h := minHeap(elements)
	heap.Init(&h)

	var score int
	for h.Len() > 0 {
		item := heap.Pop(&h).(element)
		if _, ok := marked[item.index]; ok {
			continue
		}
		score += item.value
		marked[item.index] = true
		marked[item.index+1] = true
		marked[item.index-1] = true
	}
	return int64(score)
}

type element struct {
	value int
	index int
}

type minHeap []element

func (h minHeap) Len() int {
	return len(h)
}

func (h minHeap) Less(i, j int) bool {
	if h[i].value == h[j].value {
		return h[i].index < h[j].index
	}
	return h[i].value < h[j].value
}

func (h minHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *minHeap) Push(x any) {
	*h = append(*h, x.(element))
}

func (h *minHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}