class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int count;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        count = 0;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
            crawler.count++;
        }
        crawler.isEndOfWord = true;
    }

    int searchPrefixCount(String prefix) {
        TrieNode crawler = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                return 0;
            }
            crawler = crawler.children[index];
        }
        return crawler.count;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.searchPrefixCount(pref);
    }
}