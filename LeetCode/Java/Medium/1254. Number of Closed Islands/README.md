# 📝 1254. Number of Closed Islands (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/number-of-closed-islands/?envType=daily-question&envId=2026-10-25)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

Given a 2D  `grid`  consists of  `0s`  (land) and  `1s`  (water).  An  *island*  is a maximal 4-directionally connected group of  `0s`  and a  *closed island*  is an island  **totally**  (all left, top, right, bottom) surrounded by  `1s.`

Return the number of  *closed islands* .

**Example 1:**

![image](https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png)

```
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
```

**Example 2:**

![image](https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png)

```
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

```

**Example 3:**

```
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

```

**Constraints:**

	
- `1 <= grid.length, grid[0].length <= 100`
	
- `0 <= grid[i][j] <=1`