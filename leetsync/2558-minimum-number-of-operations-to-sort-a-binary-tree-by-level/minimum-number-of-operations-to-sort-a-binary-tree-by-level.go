/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type queue struct {
	node []*TreeNode
}

func NewQueue() *queue {
	return &queue{}
}

func (q *queue) Size() int {
	return len(q.node)
}

func (q *queue) Pop() *TreeNode {
	v := q.node[0]
	q.node = q.node[1:]
	return v
}

func (q *queue) Push(v *TreeNode) {
	q.node = append(q.node, v)
}

func minimumOperations(root *TreeNode) int {
	totalSwap := 0
	levelValues := make([]int, 0, 8)
	q := NewQueue()
	q.Push(root)
	for q.Size() > 0 {
		levelValues = levelValues[:0]
		for qSize := q.Size(); qSize > 0; qSize-- {
			node := q.Pop()
			levelValues = append(levelValues, node.Val)
			if node.Left != nil {
				q.Push(node.Left)
			}
			if node.Right != nil {
				q.Push(node.Right)
			}
		}
		totalSwap += getMinSwap(levelValues)
	}
	return totalSwap
}

func getMinSwap(nums []int) int {
	swaps := 0
	sortedNums := make([]int, len(nums))
	copy(sortedNums, nums)
	sort.Ints(sortedNums)
	pos := make(map[int]int, len(nums))
	for i, v := range nums {
		pos[v] = i
	}
	for i, v := range nums {
		if nums[i] != sortedNums[i] {
			swaps++
			needPos := pos[sortedNums[i]]
			pos[v] = needPos
			nums[i], nums[needPos] = nums[needPos], nums[i]
		}
	}

	return swaps
}