class Solution {
    public int romanToInt(String romanNo) {
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
        int len = romanNo.length() - 1;
        char currentChar = romanNo.charAt(len);
        int intNo = romanToIntMap.get(currentChar);
        char previousChar = currentChar;
        while (--len >= 0) {
          currentChar = romanNo.charAt(len);
          if (romanToIntMap.get(currentChar) < romanToIntMap.get(previousChar)) {
            intNo -= romanToIntMap.get(currentChar);
          } else {
            intNo += romanToIntMap.get(currentChar);
          }
          previousChar = currentChar;
        }
        return intNo;        
    }
}