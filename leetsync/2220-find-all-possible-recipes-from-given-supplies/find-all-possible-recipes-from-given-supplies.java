class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        // Build graph
        Map<String, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (String ing : ingredients.get(i)) {
                if (!suppliesSet.contains(ing)) {
                    adj.putIfAbsent(ing, new ArrayList<>());
                    adj.get(ing).add(i);
                    inDegree[i]++;
                }
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        List<String> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int i = que.poll();
            String recipe = recipes[i];
            result.add(recipe);
            if (adj.containsKey(recipe)) {
                for (int index : adj.get(recipe)) {
                    inDegree[index]--;
                    if (inDegree[index] == 0) {
                        que.add(index);
                    }
                }
            }
        }
        return result;
    }
}