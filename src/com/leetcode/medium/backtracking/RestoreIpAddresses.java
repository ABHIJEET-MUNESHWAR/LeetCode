package com.leetcode.medium.backtracking;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   15-04-2025
    Time:   06:58 pm
    93. Restore IP Addresses
    https://leetcode.com/problems/restore-ip-addresses/description/
*/

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        String s = "25525511135";
        ArrayUtils.printStrArray(restoreIpAddresses.restoreIpAddresses(s));
    }

    public void solve(String s, List<String> result, int parts, String current, int index) {
        int n = s.length();
        if (index >= n && parts == 4) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        if ((index + 1) <= n) {
            solve(s, result, parts + 1, current + s.substring(index, index + 1) + ".", index + 1);
        }
        if ((index + 2) <= n && isValid(s.substring(index, index + 2))) {
            solve(s, result, parts + 1, current + s.substring(index, index + 2) + ".", index + 2);
        }
        if ((index + 3) <= n && isValid(s.substring(index, index + 3))) {
            solve(s, result, parts + 1, current + s.substring(index, index + 3) + ".", index + 3);
        }
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) < 256;
    }

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        if (n > 12) {
            return result;
        }
        int parts = 0;
        String current = "";
        int index = 0;
        solve(s, result, parts, current, index);
        return result;
    }
}
