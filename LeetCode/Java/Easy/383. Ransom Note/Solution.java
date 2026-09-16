class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {        
        int[] charArray = new int[26];
        int lenOfMag = magazine.length();
        for (int i = 0; i < lenOfMag; i++) {
          charArray[magazine.charAt(i) - 'a']++;
        }
        int lenOfNote = ransomNote.length();
        for (int i = 0; i < lenOfNote; i++) {
          if (charArray[ransomNote.charAt(i)-'a'] == 0) {
            return false;
          } else {
            charArray[ransomNote.charAt(i)-'a']--;
          }
        }
        return true;
    }
}