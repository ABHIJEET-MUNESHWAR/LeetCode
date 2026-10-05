# 📝 886. Score of Parentheses (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/score-of-parentheses/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
String, Stack, Bracket Sequences

### 🚀 Performance
- **Runtime:** 1 ms
- **Memory:** 43.1 MB

---

### 📜 Problem Description

Given a balanced parentheses string  `s` , return  *the  **score**  of the string* .

The  **score**  of a balanced parentheses string is based on the following rule:

	
- `"()"`  has score  `1` .
	
- `AB`  has score  `A + B` , where  `A`  and  `B`  are balanced parentheses strings.
	
- `(A)`  has score  `2 * A` , where  `A`  is a balanced parentheses string.

**Example 1:**

```
Input: s = "()"
Output: 1

```

**Example 2:**

```
Input: s = "(())"
Output: 2

```

**Example 3:**

```
Input: s = "()()"
Output: 2

```

**Constraints:**

	
- `2 <= s.length <= 50`
	
- `s`  consists of only  `'('`  and  `')'` .
	
- `s`  is a balanced parentheses string.