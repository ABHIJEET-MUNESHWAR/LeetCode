package com.leetcode.easy.string;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/02/23, Time:    4:04 pm
 * https://leetcode.com/problems/decode-the-message/
 */
public class DecodeMessage {

  public static void main(String[] args) {
    DecodeMessage decodeMessage = new DecodeMessage();
    String key = "the quick brown fox jumps over the lazy dog";
    String message = "vkbs bs t suepuv";
    System.out.println(decodeMessage.decodeMessage(key, message));
  }

  private String decodeMessage(String key, String message) {
    StringBuilder ans = new StringBuilder();//Using String Builder to append the string
    key = key.replaceAll(" ", "");
    //Removing the spaces
    HashMap<Character, Character> letters = new HashMap<>();
    //Mapping the key into a hashmap.
    char original = 'a';
    for (int i = 0; i < key.length(); i++) {
      if (!letters.containsKey(key.charAt(i))) {
        letters.put(key.charAt(i), original++);
      }
    }
    //After the first pass all the letters of the key will be mapped with their respective original letters.
    for (int i = 0; i < message.length(); i++) {
      if (letters.containsKey(message.charAt(i))) {
        //Now replacing the letters of the message with appropriate letter according to the key
        ans.append(letters.get(message.charAt(i)));
      } else {
        ans.append(message.charAt(i));
        //This is for characters other than the letters in the key example a space " "
        //They will not be replaced by any letters hence original letter is appended into the StringBuilder
      }
    }
    return ans.toString();
  }
}