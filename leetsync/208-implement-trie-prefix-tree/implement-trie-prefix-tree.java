class Trie {
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */