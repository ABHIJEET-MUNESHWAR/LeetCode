package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/10/22, Time:    6:59 AM
 * https://leetcode.com/problems/keyboard-row/
 */
public class KeyboardRow {

  public static void main(String[] args) {
    KeyboardRow keyboardRow = new KeyboardRow();
    String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
    String[] canBeTyped = keyboardRow.findWords(words);
  }

  private String[] findWords(String[] words) {
    ArrayList<String> canBeTyped = new ArrayList<>();
    int size = words.length;
    String firstRow = "qwertyuiop";
    String secondRow = "asdfghjkl";
    String thirdRow = "zxcvbnm";
    Set<Character> firstRowSet = firstRow.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
    Set<Character> secondRowSet = secondRow.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
    Set<Character> thirdRowSet = thirdRow.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
    for (int i = 0; i < size; i++) {
      String originalWord = words[i];
      String word = originalWord.toLowerCase(Locale.ROOT);
      if(firstRowSet.contains(word.charAt(0))){
        boolean isFound = true;
        for(Character ch: word.toCharArray()){
          if(!firstRowSet.contains(ch)){
            isFound = false;
            break;
          }
        }
        if(isFound){
          canBeTyped.add(originalWord);
        }
      } else if(secondRowSet.contains(word.charAt(0))){
        boolean isFound = true;
        for(Character ch: word.toCharArray()){
          if(!secondRowSet.contains(ch)){
            isFound = false;
            break;
          }
        }
        if(isFound){
          canBeTyped.add(originalWord);
        }
      } else if(thirdRowSet.contains(word.charAt(0))){
        boolean isFound = true;
        for(Character ch: word.toCharArray()){
          if(!thirdRowSet.contains(ch)){
            isFound = false;
            break;
          }
        }
        if(isFound){
          canBeTyped.add(originalWord);
        }
      }
    }
    return canBeTyped.toArray(new String[canBeTyped.size()]);
  }
}