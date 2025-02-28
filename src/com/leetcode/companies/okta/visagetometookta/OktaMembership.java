package com.leetcode.companies.okta.visagetometookta;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-02-2025
    Time:   04:50 pm
*/

public class OktaMembership {
    private String groupName;
    private String userName;

    public OktaMembership(String groupName, String userName) {
        this.groupName = groupName;
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
