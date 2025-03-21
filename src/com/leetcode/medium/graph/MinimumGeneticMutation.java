package com.leetcode.medium.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/06/24,
 * Time:    6:06 pm
 */
public class MinimumGeneticMutation {
  public static void main(String[] args) {
    MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
    String startGene = "AACCGGTT", endGene = "AAACGGTA";
    String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
    System.out.println(minimumGeneticMutation.minMutation(startGene, endGene, bank));
  }

  private int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> bankGeneSet = new HashSet<>();
    for (String bankGene : bank) {
      bankGeneSet.add(bankGene);
    }
    Set<String> visitedGeneSet = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(startGene);
    visitedGeneSet.add(startGene);
    char[] choices = {'A', 'C', 'G', 'T'};
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