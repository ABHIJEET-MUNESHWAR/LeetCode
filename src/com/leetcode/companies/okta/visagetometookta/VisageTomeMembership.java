package com.leetcode.companies.okta.visagetometookta;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-02-2025
    Time:   04:48 pm
*/

public class VisageTomeMembership {
    public static enum Type{
        GROUP, USER;
    }
    private Type type;
    private String name;

    public VisageTomeMembership(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
