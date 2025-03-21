class Solution {
    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] count = new int[26];
        count = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            count = intersection(count, count(words[i]));
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                while (count[i] > 0) {
                    char a = 'a';
                    a += i;
                    String s = String.valueOf(a);
                    list.add(s);
                    count[i]--;
                }
            }
        }
        return list;
    }

    private int[] intersection(int[] a, int[] b) {
        int[] temp = new int[26];
        for (int i = 0; i < 26; i++) {
            temp[i] = Math.min(a[i], b[i]);
        }
        return temp;
    }

    private int[] count(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        return count;
    }
}