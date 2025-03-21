type pair struct {
	char  byte
	count int
}

type maxHeap []pair

func (h maxHeap) Len() int {
	return len(h)
}

func (h maxHeap) Less(i, j int) bool {
	return h[i].char > h[j].char
}

func (h maxHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *maxHeap) Pop() any {
	old := *h
	n := len(old)
	item := old[n-1]
	*h = old[:n-1]
	return item
}

func (h *maxHeap) Push(x any) {
	*h = append(*h, x.(pair))
}

func repeatLimitedString(s string, repeatLimit int) string {
	result := []byte{}
	freq := map[byte]int{}

	for i := 0; i < len(s); i++ {
		freq[s[i]]++
	}

	h := maxHeap{}
	for char, count := range freq {
		h = append(h, pair{char: char, count: count})
	}

	heap.Init(&h)

	for len(h) > 0 {
		currentPair := heap.Pop(&h).(pair)
		k := min(currentPair.count, repeatLimit)

		for i := 0; i < k; i++ {
			result = append(result, currentPair.char)
		}

		currentPair.count -= k

		if currentPair.count > 0 {
			if len(h) == 0 {
				break
			}
			nextPair := heap.Pop(&h).(pair)
			result = append(result, nextPair.char)
			nextPair.count--
			if nextPair.count > 0 {
				heap.Push(&h, nextPair)
			}
			heap.Push(&h, currentPair)
		}
	}
	return string(result)
}