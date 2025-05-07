package com.leetcode.companies.adyen.oa.social;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   01-05-2025
    Time:   02:37 pm
*/

import java.util.HashMap;
import java.util.Map;

public class Platform {
    private Map<Integer, User> users;

    public Platform() {
        this.users = new HashMap<>();
    }

    public void addUser(Integer id, String name) {
        if (!users.containsKey(id)) {
            User newUser = new User(id, name);
            users.put(id, newUser);
            System.out.println(name + " added successfully.");
        }
    }

    public void follow(Integer followerId, Integer followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower != null && followee != null) {
            follower.follow(followee);
        }
    }

    public void unFollow(Integer followerId, Integer followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower != null && followee != null) {
            follower.unfollow(followee);
        }
    }

    public void post(Integer userId, String content) {
        User user = users.get(userId);
        if (user != null) {
            user.post(content);
        }
    }
}
