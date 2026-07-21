# Detect Cycle using DSU

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1)

## Solved On
21 Jul 2026 at 06:22 pm

<h2><a href="https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1">Detect Cycle using DSU</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 18px;">Given an <strong>undirected graph</strong> with <strong>no self loops</strong> with <strong>V (from 0 to V-1)</strong> nodes and <strong>E</strong> edges, return <strong>true</strong> if there is any <strong>cycle </strong>in the <strong>undirected graph </strong>other wise return <strong>false</strong>.</span></p>
<p><span style="font-size: 18px;"><strong>Note:</strong> Solve the problem using <strong>disjoint set union (DSU).</strong></span></p>
<p><span style="font-size: 18px;"><strong>Examples</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: 
</strong></span><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/701410/Web/Other/blobid0_1745299580.jpg" width="303" height="268"><br><span style="font-size: 18px;"><strong>Output:</strong> true
<strong>Explanation: </strong>There is a cycle between 0-&gt;2-&gt;4-&gt;0</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: 
</strong></span><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/701410/Web/Other/blobid1_1745299616.jpg" width="307" height="272"><br><span style="font-size: 18px;"><strong>Output: </strong>false
<strong>Explanation: </strong>The graph doesn't contain any cycle</span>
</pre>
<p><span style="font-size: 18px;"><strong>Constraints:<br></strong></span><span style="font-size: 18px;">2 ≤ V ≤ 10<sup>4<br></sup></span><span style="font-size: 18px;">1 ≤ E ≤ 10<sup>4</sup></span></p>