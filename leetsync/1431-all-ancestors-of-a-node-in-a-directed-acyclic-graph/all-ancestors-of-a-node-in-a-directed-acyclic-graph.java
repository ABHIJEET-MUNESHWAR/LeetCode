class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> ancestorList = new ArrayList();
        List<List<Integer>> list = new ArrayList();

        Queue<Integer> queue = new LinkedList();

        int inDegree[] = new int[n];
        ArrayList<Integer>[] connections = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            connections[i] = new ArrayList<Integer>();
            ancestorList.add(new TreeSet<Integer>());
        }

        for (int edge[] : edges) {
            connections[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int currNode = queue.poll();
            for (int node : connections[currNode]) {
                ancestorList.get(node).addAll(new TreeSet(ancestorList.get(currNode)));
                ancestorList.get(node).add(currNode);

                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }
        for (TreeSet<Integer> set : ancestorList) {
            list.add(new ArrayList<Integer>(set));
        }

        return list;
    }
}