package com.leetcode.companies.wayfair;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    10:46 pm
 * Autocomplete Prototype
 * https://leetcode.com/discuss/interview-question/5505127/Wayfair-Software-Engineer-II-OA
 */
public class AutocompletePrototype {
    public static void main(String[] args) {
        AutocompletePrototype autocompletePrototype = new AutocompletePrototype();
        String[] words = {"duel", "speed", "dule", "cars"};
        String[] queries = {"spede", "deul"};
        ListUtils.printStringLists(autocompletePrototype.autocompletePrototype(words, queries));
    }

    private List<List<String>> autocompletePrototype(String[] words, String[] queries) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> stringToFrequencyMap = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            List<String> frequencyList = stringToFrequencyMap.getOrDefault(sortedWord, new ArrayList<>());
            frequencyList.add(word);
            stringToFrequencyMap.put(sortedWord, frequencyList);
        }
        for (String query : queries) {
            char[] chars = query.toCharArray();
            Arrays.sort(chars);
            String sortedQuery = new String(chars);
            if (stringToFrequencyMap.containsKey(sortedQuery)) {
                lists.add(stringToFrequencyMap.get(sortedQuery));
            }
        }
        return lists;
    }
}