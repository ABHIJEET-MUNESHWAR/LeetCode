# Meeting Rooms II

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/attend-all-meetings-ii/1)

## Solved On
27 Oct 2026 at 02:19 pm

<h2><a href="https://www.geeksforgeeks.org/problems/attend-all-meetings-ii/1">Meeting Rooms II</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 14pt;">Given two arrays&nbsp;<strong>start[] </strong>and<strong> end[]</strong> such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Return the <strong>minimum number</strong> of rooms required to attend all meetings.</span></p>
<p><span style="font-size: 14pt;"><strong>Note:</strong> A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>start[] = [1, 10, 7], end[] = [4, 15, 10]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>start[] = [2, 9, 6], end[] = [4, 12, 10]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1st and 2nd meetings at one room but for 3rd meeting one another room required.<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong></span><br><span style="font-size: 14pt;">1 ≤ start.size() = end.size() ≤ 10<sup>5</sup></span><br><span style="font-size: 14pt;">0 ≤ start[i] &lt; end[i] ≤ 10<sup>6</sup></span></p>