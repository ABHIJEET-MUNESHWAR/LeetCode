# 📝 3823. Count Islands With Total Value Divisible by K (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

You are given an  `m x n`  matrix  `grid`  and a positive integer  `k` . An  **island**  is a group of  **positive**  integers (representing land) that are  **4-directionally**  connected (horizontally or vertically).

The  **total value**  of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value  **divisible by**   `k` .

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2025/03/06/example1griddrawio-1.png) 

**Input:**  grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

**Output:**  2

**Explanation:**

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

**Example 2:**

 ![image](https://assets.leetcode.com/uploads/2025/03/06/example2griddrawio.png) 

**Input:**  grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3

**Output:**  6

**Explanation:**

The grid contains six islands, each with a total value that is divisible by 3.

**Constraints:**

	
- `m == grid.length`
	
- `n == grid[i].length`
	
- `1 <= m, n <= 1000`
	
- `1 <= m * n <= 105`
	
- `0 <= grid[i][j] <= 106`
	
- `1 <= k <= 106`