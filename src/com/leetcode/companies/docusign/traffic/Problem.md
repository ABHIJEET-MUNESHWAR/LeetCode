**Coding Challenge — Traffic-Aware Route Planner**

You are building a navigation service that finds the best route between a user's home and work location.

The city is represented as a directed graph:

* Each location is a node.
* Each road is a directed edge.
* Every road has:
* distance in kilometers
* travelTime in minutes



Your task is to find the **best route** from a given source to a destination.

**Route Selection Rules**

1. Choose the route with the **minimum total travel time**.
2. If multiple routes have the same total travel time, choose the route with the **minimum total distance**.

All distances and travel times are positive integers.

---

**Input Format**

```text
N M
u1 v1 distance1 travelTime1
u2 v2 distance2 travelTime2
...
uM vM distanceM travelTimeM
source destination

```

**Where:**

* $N$ = number of locations.
* $M$ = number of roads.
* $u$ $v$ $distance$ $travelTime$ represents a directed road from location $u$ to location $v$.
* Locations are numbered from $1$ to $N$.
* $source$ is the starting location.
* $destination$ is the target location.

---

**Output Format**

If a route exists, print:

```text
Minimum Travel Time: <time>
Total Distance: <distance>
Path: <node1> <node2> ... <destination>

```

If no route exists, print:

```text
No Route

```

---

**Example Input**

```text
5 7
1 2 5 10
1 3 7 8
2 4 8 12
3 4 10 14
2 3 2 3
4 5 4 6
3 5 15 18
1 5

```

**Example Output**

```text
Minimum Travel Time: 26
Total Distance: 22
Path: 1 3 5

```

---

**Constraints**

* $1 \le N \le 100000$
* $1 \le M \le 300000$
* $1 \le \text{distance} \le 10000$
* $1 \le \text{travelTime} \le 10000$
* $1 \le \text{source, destination} \le N$

The graph may contain cycles, disconnected locations, multiple outgoing roads from the same location, and multiple roads between the same pair of locations.

Your solution should handle large graphs efficiently and return:

1. Minimum total travel time.
2. Minimum total distance among routes having that travel time.
3. The actual path from source to destination.