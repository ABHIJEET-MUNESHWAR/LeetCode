class Solution {

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

    public String replaceWords(List<String> dictionary, String sentence) {
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