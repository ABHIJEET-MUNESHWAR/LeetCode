package com.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/11/22, Time:    1:36 pm
 */
public class NaryTreeNode {

  public int val;
  public List<NaryTreeNode> children;

  public NaryTreeNode() {
  }

  public NaryTreeNode(int val) {
    this.val = val;
    this.children = new ArrayList<>();
  }

  public NaryTreeNode(int val, List<NaryTreeNode> children) {
    this.val = val;
    this.children = children;
  }
}