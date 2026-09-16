# 📝 49. Group Anagrams (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/group-anagrams/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Array, Hash Table, String, Sorting

### 🚀 Performance
- **Runtime:** 7 ms
- **Memory:** 49.4 MB

---

### 📜 Problem Description

Given an array of strings  `strs` , group the anagrams together. You can return the answer in  **any order** .

**Example 1:**

**Input:**  strs = ["eat","tea","tan","ate","nat","bat"]

**Output:**  [["bat"],["nat","tan"],["ate","eat","tea"]]

**Explanation:**

	
- There is no string in strs that can be rearranged to form  `"bat"` .
	
- The strings  `"nat"`  and  `"tan"`  are anagrams as they can be rearranged to form each other.
	
- The strings  `"ate"` ,  `"eat"` , and  `"tea"`  are anagrams as they can be rearranged to form each other.

**Example 2:**

**Input:**  strs = [""]

**Output:**  [[""]]

**Example 3:**

**Input:**  strs = ["a"]

**Output:**  [["a"]]

**Constraints:**

	
- `1 <= strs.length <= 104`
	
- `0 <= strs[i].length <= 100`
	
- `strs[i]`  consists of lowercase English letters.