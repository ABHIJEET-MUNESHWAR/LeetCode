# 📝 20. Valid Parentheses (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/valid-parentheses/)

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
String, Stack, Bracket Sequences

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

Given a string  `s`  containing just the characters  `'('` ,  `')'` ,  `'{'` ,  `'}'` ,  `'['`  and  `']'` , determine if the input string is valid.

An input string is valid if:

	
1. Open brackets must be closed by the same type of brackets.
	
2. Open brackets must be closed in the correct order.
	
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

**Input:**  s = "()"

**Output:**  true

**Example 2:**

**Input:**  s = "()[]{}"

**Output:**  true

**Example 3:**

**Input:**  s = "(]"

**Output:**  false

**Example 4:**

**Input:**  s = "([])"

**Output:**  true

**Example 5:**

**Input:**  s = "([)]"

**Output:**  false

**Constraints:**

	
- `1 <= s.length <= 104`
	
- `s`  consists of parentheses only  `'()[]{}'` .