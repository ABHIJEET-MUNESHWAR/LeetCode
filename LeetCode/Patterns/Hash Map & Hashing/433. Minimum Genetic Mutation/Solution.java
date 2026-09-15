class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankGeneSet = new HashSet<>();
        for (String bankGene : bank) {
            bankGeneSet.add(bankGene);
        }
        Set<String> visitedGeneSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visitedGeneSet.add(startGene);
        char[] choices = { 'A', 'C', 'G', 'T' };
        int levels = 0;
        int geneSize = startGene.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return levels;
                }
                for (char choice : choices) {
                    for (int i = 0; i < geneSize; i++) {
                        char[] currentGeneCharArray = currentGene.toCharArray();
                        if (currentGeneCharArray[i] != choice) {
                            currentGeneCharArray[i] = choice;
                            String mutatedGene = new String(currentGeneCharArray);
                            if (!visitedGeneSet.contains(mutatedGene) && bankGeneSet.contains(mutatedGene)) {
                                visitedGeneSet.add(mutatedGene);
                                queue.add(mutatedGene);
                            }
                        }
                    }
                }
            }
            levels++;
        }
        return -1;
    }
}