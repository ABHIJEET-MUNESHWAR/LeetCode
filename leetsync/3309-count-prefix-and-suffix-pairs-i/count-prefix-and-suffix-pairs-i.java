class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode pCrawl = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public boolean searchPrefix(String prefix) {
        TrieNode pCrawl = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return true;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int j = 0; j < n; j++) {
            Trie prefixTree = new Trie();
            Trie suffixTree = new Trie();
            prefixTree.insert(words[j]);
            String reversed = new StringBuilder(words[j]).reverse().toString();
            suffixTree.insert(reversed);
            for (int i = 0; i < j; i++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }
                String rev = new StringBuilder(words[i]).reverse().toString();
                if (prefixTree.searchPrefix(words[i]) && suffixTree.searchPrefix(rev)) {
                    count++;
                }
            }
        }
        return count;
    }
}