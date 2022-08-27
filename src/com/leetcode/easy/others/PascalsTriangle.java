package com.leetcode.easy.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    6:01 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
 */
public class PascalsTriangle {

  public static void main(String[] args) {
    PascalsTriangle pascalsTriangle = new PascalsTriangle();
    List<List<Integer>> triangle = pascalsTriangle.generate(5);
  }

  private List<List<Integer>> generate(int numRows) {
    List<List<Integer>> answerLists = new ArrayList<List<Integer>>();
    for(int i=0; i<numRows; i++){
      List<Integer> row = new ArrayList<>();
      for(int j=0; j<i+1; j++){
        if(j==0 || j==i){
          row.add(1);
        } else {
          row.add(answerLists.get(i-1).get(j-1)+answerLists.get(i-1).get(j));
        }
      }
      answerLists.add(row);
    }
    return answerLists;
  }
}