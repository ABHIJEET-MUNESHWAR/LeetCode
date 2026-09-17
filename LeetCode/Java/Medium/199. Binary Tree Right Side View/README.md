# 📝 199. Binary Tree Right Side View (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/binary-tree-right-side-view/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Tree, Depth-First Search, Breadth-First Search, Binary Tree

### 🚀 Performance
- **Runtime:** 0 ms
- **Memory:** 41.2 MB

---

### 📜 Problem Description

Given the  `root`  of a binary tree, imagine yourself standing on the  **right side**  of it, return  *the values of the nodes you can see ordered from top to bottom* .

**Example 1:**

**Input:**  root = [1,2,3,null,5,null,4]

**Output:**  [1,3,4]

**Explanation:**

![image](https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png)

**Example 2:**

**Input:**  root = [1,2,3,4,null,null,null,5]

**Output:**  [1,3,4,5]

**Explanation:**

![image](https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png)

**Example 3:**

**Input:**  root = [1,null,3]

**Output:**  [1,3]

**Example 4:**

**Input:**  root = []

**Output:**  []

**Constraints:**

	
- The number of nodes in the tree is in the range  `[0, 100]` .
	
- `-100 <= Node.val <= 100`