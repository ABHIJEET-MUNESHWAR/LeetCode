/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type FindElements struct {
	set map[int]bool
}

func Constructor(root *TreeNode) FindElements {
	set := make(map[int]bool)
	dfs(root, 0, set)
	return FindElements{
		set: set,
	}
}

func dfs(root *TreeNode, value int, set map[int]bool) {
	if root == nil {
		return
	}
	root.Val = value
	set[value] = true
	dfs(root.Left, value*2+1, set)
	dfs(root.Right, value*2+2, set)
}

func (this *FindElements) Find(target int) bool {
	return this.set[target]
}

/**
 * Your FindElements object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Find(target);
 */