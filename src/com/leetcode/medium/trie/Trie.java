package com.leetcode.medium.trie;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/06/24,
 * Time:    10:44 pm
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class Trie {
  class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode() {
      isEndOfWord = false;
      children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
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
    TrieNode crawler = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (crawler.children[c - 'a'] == null) {
        return false;
      }
      crawler = crawler.children[c - 'a'];
    }
    return crawler != null && crawler.isEndOfWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode crawler = root;
    int i = 0;
    for (i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (crawler.children[c - 'a'] == null) {
        return false;
      }
      crawler = crawler.children[c - 'a'];
    }
    return i == prefix.length();
  }
}