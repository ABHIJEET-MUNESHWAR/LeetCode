package com.leetcode.companies.adyen.oa.social;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   01-05-2025
    Time:   02:36 pm
*/


import java.util.Set;
import java.util.TreeSet;

public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private Set<User> followers;
    private Set<User> following;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new TreeSet<>();
        this.following = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void update(String message, User followee) {
        System.out.println(this.name + " received notification: " + followee.getName() + " posted: \"" + message + "\".");
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollowers(User user) {
        followers.remove(user);
    }

    public void notifyFollowers(String message) {
        for (User follower : followers) {
            follower.update(message, this);
        }
    }

    public void post(String message) {
        System.out.println(this.name + " posted: \"" + message + "\"");
        notifyFollowers(message);
    }

    public void follow(User user) {
        if (this.following.add(user)) {
            user.addFollower(this);
            System.out.println(this.name + " is now following " + user.getName() + ".");
        }
    }

    public void unfollow(User user) {
        if (this.following.remove(user)) {
            user.removeFollowers(this);
            System.out.println(this.name + " has unfollowed " + user.getName() + ".");
        }
    }

    @Override
    public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }
}
