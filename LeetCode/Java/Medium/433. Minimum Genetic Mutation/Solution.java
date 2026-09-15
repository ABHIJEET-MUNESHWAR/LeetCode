class Solution {
    public int minMutation(String startGene, String endGene, String[] banks) {
        Set<String> bankSet = new HashSet<>();
        for (String bank : banks) {
            bankSet.add(bank);
        }
        Set<String> isVisitedGeneSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        isVisitedGeneSet.add(startGene);
        int level = 0;
        char[] choices = { 'A', 'C', 'G', 'T' };
        int geneSize = startGene.length();
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return level;
                }
                for (char choice : choices) {
                    for (int i = 0; i < geneSize; i++) {
                        char[] currentGeneArray = currentGene.toCharArray();
                        if (currentGeneArray[i] != choice) {
                            currentGeneArray[i] = choice;
                            String mutatedGene = new String(currentGeneArray);
                            if (!isVisitedGeneSet.contains(mutatedGene) && bankSet.contains(mutatedGene)) {
                                isVisitedGeneSet.add(mutatedGene);
                                queue.offer(mutatedGene);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}