# 📝 678. Valid Parenthesis String (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/valid-parenthesis-string/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
String, Dynamic Programming, Stack, Greedy, Bracket Sequences

### 🚀 Performance
- **Runtime:** N/A
- **Memory:** N/A

---

### 📜 Problem Description

Given a string  `s`  containing only three types of characters:  `'('` ,  `')'`  and  `'*'` , return  `true`   *if*   `s`   *is  **valid*** .

The following rules define a  **valid**  string:

	
- Any left parenthesis  `'('`  must have a corresponding right parenthesis  `')'` .
	
- Any right parenthesis  `')'`  must have a corresponding left parenthesis  `'('` .
	
- Left parenthesis  `'('`  must go before the corresponding right parenthesis  `')'` .
	
- `'*'`  could be treated as a single right parenthesis  `')'`  or a single left parenthesis  `'('`  or an empty string  `""` .

**Example 1:**

```
Input: s = "()"
Output: true

```

**Example 2:**

```
Input: s = "(*)"
Output: true

```

**Example 3:**

```
Input: s = "(*))"
Output: true

```

**Example 4:**

```
Input: s = "("
Output: false

```

**Constraints:**

	
- `1 <= s.length <= 100`
	
- `s[i]`  is  `'('` ,  `')'`  or  `'*'` .