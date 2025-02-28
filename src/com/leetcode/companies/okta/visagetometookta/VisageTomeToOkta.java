package com.leetcode.companies.okta.visagetometookta;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-02-2025
    Time:   04:47 pm
*/
/*
In Okta, two of the most important objects are users and groups. Sometimes, we import users, groups, and memberships from other applications, like Google Apps or Workday. Of course, these other applications represent groups, users, and memberships differently than us. Let’s say we want to pull group information from an awesome new app, VisageTome.

VisageTome represents group memberships as a map, where the keys are group names, and the values are a list of memberships of the group. However, VisageTome allows for nesting groups, or subgroups, so a membership can be either a group or a user.

Okta represents group memberships as a List of Membership objects, which each contain a group name and a username.

Implement a function that takes in a map of VisageTome group memberships, where the keys are group names and the values are lists of memberships, and returns a list of Okta group memberships.

[execution time limit] 3 seconds (java)

[memory limit] 1 GB
 */

import java.util.*;

public class VisageTomeToOkta {
    public static void main(String[] args) {
        /**
         / Example:
         / INPUT:
         /   group1 -> [(user1(Type USER, name user1), group2 (type GROUP, name group2))]
         /   group2 -> [(user2(Type USER, name user2), user3 (type USER, name user3))]
         / OUTPUT:
         /   [(user1, group1), (user2, group1), (user3, group1), (user2, group2), (user3, group2)]
         / g1
         / |.-- g2
         / |----------u2
         / |----------u3
         / |---u1
         **/
        Map<String, List<VisageTomeMembership>> groupMembersMultimap = new HashMap<>();

        List<VisageTomeMembership> memberships= new ArrayList<>();

        memberships.add(new VisageTomeMembership(VisageTomeMembership.Type.USER, "user1"));
        memberships.add(new VisageTomeMembership(VisageTomeMembership.Type.GROUP, "group2"));
        groupMembersMultimap.put("group1", memberships);

        memberships = new ArrayList<>();
        memberships.add(new VisageTomeMembership(VisageTomeMembership.Type.USER, "user2"));
        memberships.add(new VisageTomeMembership(VisageTomeMembership.Type.USER, "user3"));
        groupMembersMultimap.put("group2", memberships);

        VisageTomeToOkta visageTomeToOkta = new VisageTomeToOkta();
        List<OktaMembership> result = visageTomeToOkta.computeOktaMemberships(groupMembersMultimap);
        for(OktaMembership membership: result){
            System.out.println(membership.getUserName() + "," + membership.getGroupName());
        }
    }

    private List<OktaMembership> computeOktaMemberships(Map<String, List<VisageTomeMembership>> groupMembersMultimap) {
        List<OktaMembership> oktaMemberships = new ArrayList<>();
        Set<String> visitedGroups = new HashSet<>();
        for (String group : groupMembersMultimap.keySet()) {
            traverseGroup(group, group, groupMembersMultimap, oktaMemberships, visitedGroups);
        }

        return oktaMemberships;
    }

    private static void traverseGroup(String parentGroup, String currentGroup,
                                      Map<String, List<VisageTomeMembership>> groupMembersMultimap,
                                      List<OktaMembership> oktaMemberships,
                                      Set<String> visitedGroups) {
        if (visitedGroups.contains(currentGroup)) {
            return;
        }
        visitedGroups.add(currentGroup);

        List<VisageTomeMembership> members = groupMembersMultimap.getOrDefault(currentGroup, new ArrayList<>());
        for (VisageTomeMembership member : members) {
            if (member.getType() == VisageTomeMembership.Type.USER) {
                oktaMemberships.add(new OktaMembership(parentGroup, member.getName()));
            } else if (member.getType() == VisageTomeMembership.Type.GROUP) {
                traverseGroup(parentGroup, member.getName(), groupMembersMultimap, oktaMemberships, visitedGroups);
            }
        }
        visitedGroups.remove(currentGroup);
    }
}
