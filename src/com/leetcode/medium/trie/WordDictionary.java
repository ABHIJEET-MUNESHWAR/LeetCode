package com.leetcode.medium.trie;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/06/24,
 * Time:    10:06 pm
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */
public class WordDictionary {
  class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode() {
      isEndOfWord = false;
      children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode crawler = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (crawler.children[c - 'a'] == null) {
        crawler.children[c - 'a'] = new TrieNode();
      }
      crawler = crawler.children[c - 'a'];
    }
    crawler.isEndOfWord = true;
  }

  public boolean search(String word) {
    return searchUtil(root, word);
  }

  private boolean searchUtil(TrieNode root, String word) {
    TrieNode crawler = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (int j = 0; j < 26; j++) {
          if (crawler.children[j] != null) {
            if (searchUtil(crawler.children[j], word.substring(i + 1))) {
              return true;
            }
          }
        }
        return false;
      }
      if (crawler.children[c - 'a'] == null) {
        return false;
      }
      crawler = crawler.children[c - 'a'];
    }
    return crawler != null && crawler.isEndOfWord;
  }

  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
  }
}