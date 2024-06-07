package com.leetcode.medium.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    7:15 am
 * 648. Replace Words
 * https://leetcode.com/problems/replace-words/description/?envType=daily-question&envId=2024-06-07
 */
public class ReplaceWords {
  public static void main(String[] args) {
    ReplaceWords replaceWords = new ReplaceWords();
    List<String> dictionary = new ArrayList<String>();
    dictionary.add("cat");
    dictionary.add("bat");
    dictionary.add("rat");
    String sentence = "the cattle was rattled by the battery";
    System.out.println(replaceWords.replaceWords(dictionary, sentence));
  }

  class TrieNode {
    char val;
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(char val) {
      this.val = val;
      isEndOfWord = false;
      children = new TrieNode[26];
    }
  }

  private String replaceWords(List<String> dictionary, String sentence) {
    TrieNode root = buildTrie(dictionary);
    return replaceWords(root, sentence);
  }

  private String replaceWords(TrieNode root, String sentence) {
    StringBuilder sb = new StringBuilder();
    String[] tokens = sentence.split(" ");
    for (String token : tokens) {
      sb.append(getShortestReplacement(token, root));
      sb.append(' ');
    }
    return sb.substring(0, sb.length() - 1);
  }

  private String getShortestReplacement(String token, TrieNode root) {
    TrieNode crawlerNode = root;
    StringBuilder sb = new StringBuilder();
    for (char c : token.toCharArray()) {
      sb.append(c);
      if (crawlerNode.children[c - 'a'] != null) {
        if (crawlerNode.children[c - 'a'].isEndOfWord) {
          return sb.toString();
        }
        crawlerNode = crawlerNode.children[c - 'a'];
      } else {
        return token;
      }
    }
    return token;
  }

  private TrieNode buildTrie(List<String> dictionary) {
    TrieNode root = new TrieNode(' ');
    for (String word : dictionary) {
      TrieNode crawlerNode = root;
      for (char c : word.toCharArray()) {
        if (crawlerNode.children[c - 'a'] == null) {
          crawlerNode.children[c - 'a'] = new TrieNode(c);
        }
        crawlerNode = crawlerNode.children[c - 'a'];
      }
      crawlerNode.isEndOfWord = true;
    }
    return root;
  }
}