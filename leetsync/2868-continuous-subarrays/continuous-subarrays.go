func continuousSubarrays(nums []int) int64 {
	n := len(nums)
	minHeap := MinHeap{}
	maxHeap := MaxHeap{}
	var count int64
	i, j := 0, 0
	for j < n {
		heap.Push(&minHeap, &Item{value: nums[j], index: j})
		heap.Push(&maxHeap, &Item{value: nums[j], index: j})

		for maxHeap[0].value-minHeap[0].value > 2 {
			i++
			for minHeap[0].index < i {
				heap.Pop(&minHeap)
			}
			for maxHeap[0].index < i {
				heap.Pop(&maxHeap)
			}
		}
		count += int64(j - i + 1)

		j++
	}
	return count
}

type Item struct {
	value int
	index int
}

type MinHeap []*Item

func (pq MinHeap) Len() int {
	return len(pq)
}

func (pq MinHeap) Less(i, j int) bool {
	return pq[i].value < pq[j].value
}

func (pq MinHeap) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *MinHeap) Push(x any) {
	*pq = append(*pq, x.(*Item))
}

func (pq *MinHeap) Pop() any {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil
	*pq = old[0 : n-1]
	return item
}

type MaxHeap []*Item

func (pq MaxHeap) Len() int {
	return len(pq)
}
func (pq MaxHeap) Less(i, j int) bool {
	return pq[i].value > pq[j].value
}
func (pq MaxHeap) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *MaxHeap) Push(x any) {
	*pq = append(*pq, x.(*Item))
}

func (pq *MaxHeap) Pop() any {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil
	*pq = old[0 : n-1]
	return item
}