# 📝 64. Minimum Path Sum (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/minimum-path-sum/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Dynamic Programming, Matrix

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

Given a  `m x n`   `grid`  filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

**Note:**  You can only move either down or right at any point in time.

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg) 

```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

```

**Example 2:**

```
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

```

**Constraints:**

	
- `m == grid.length`
	
- `n == grid[i].length`
	
- `1 <= m, n <= 200`
	
- `0 <= grid[i][j] <= 200`