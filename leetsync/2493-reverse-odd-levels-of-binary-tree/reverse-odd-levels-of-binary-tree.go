/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func reverseOddLevels(root *TreeNode) *TreeNode {
	var reverseOdd func(*TreeNode, *TreeNode, bool)
	reverseOdd = func(left, right *TreeNode, isOdd bool) {
		if left == nil || right == nil {
			return
		}
		if isOdd {
			left.Val, right.Val = right.Val, left.Val
		}
		reverseOdd(left.Left, right.Right, !isOdd)
		reverseOdd(left.Right, right.Left, !isOdd)
	}
	reverseOdd(root.Left, root.Right, true)
	return root
}