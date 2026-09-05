# Undirected Graph Cycle

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)

## Solved On
05 Sept 2026 at 02:48 pm

<h2><a href="https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1">Undirected Graph Cycle</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 18.6667px;">Given an undirected graph<strong> </strong>with <strong>V</strong> vertices and<strong> E </strong>edges, represented as a 2D vector <strong>edges[][]</strong>, where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle<strong> </strong>or not. </span></p>
<p><span style="font-size: 18.6667px;"><strong>Note:</strong> The graph can have multiple component.</span><span style="font-size: 18px;"><img style="font-size: 18px; font-weight: bold;" src="C:\Users\Mukul kumar\Desktop\GFG_PIC.JPG" alt=""></span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
<strong>Output: </strong>true
<strong>Explanation:</strong> 
</span><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid1_1743510240.jpg" width="176" height="158"><br><span style="font-size: 18px;">1 -&gt; 2 -&gt; 0 -&gt; 1 is a cycle.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]</span>
<strong><span style="font-size: 18px;">Output: </span></strong><span style="font-size: 18px;">false</span><span style="font-size: 18px;">
<strong>Explanation: 
</strong></span><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid2_1743510254.jpg" width="169" height="153"><br><span style="font-size: 18px;">No cycle in the graph.</span>
</pre>
<p><span style="font-size: 18px;"><strong style="font-size: 18px;">Constraints:<br></strong><span style="font-size: 18px;">1 ≤ V, E ≤ 10</span><sup style="font-size: 18px;">5</sup><br><span style="font-size: 18px;">0 ≤ edges[i][0], edges[i][1] &lt; V</span></span></p>