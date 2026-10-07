# 📝 301. Remove Invalid Parentheses (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/remove-invalid-parentheses/?envType=daily-question&envId=2026-10-07)

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
String, Backtracking, Breadth-First Search

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

Given a string  `s`  that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return  *a list of  **unique strings**  that are valid with the minimum number of removals* . You may return the answer in  **any order** .

**Example 1:**

```
Input: s = "()())()"
Output: ["(())()","()()()"]

```

**Example 2:**

```
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

```

**Example 3:**

```
Input: s = ")("
Output: [""]

```

**Constraints:**

	
- `1 <= s.length <= 25`
	
- `s`  consists of lowercase English letters and parentheses  `'('`  and  `')'` .
	
- There will be at most  `20`  parentheses in  `s` .