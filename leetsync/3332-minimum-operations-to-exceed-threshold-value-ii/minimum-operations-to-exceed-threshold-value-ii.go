type MinHeap []int

func (h MinHeap) Len() int {
	return len(h)
}
func (h MinHeap) Less(i, j int) bool {
	return h[i] < h[j]
}
func (h MinHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}
func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *MinHeap) Pop() interface{} {
	x := (*h)[len(*h)-1]
	*h = (*h)[:len(*h)-1]
	return x
}
func minOperations(nums []int, k int) int {
	h := &MinHeap{}
	heap.Init(h)
	for _, num := range nums {
		heap.Push(h, num)
	}
	var operations int
	for h.Len() > 1 && (*h)[0] < k {
		x := heap.Pop(h).(int)
		y := heap.Pop(h).(int)
		z := min(x, y)*2 + max(x, y)
		heap.Push(h, z)
		operations++
	}
	return operations
}