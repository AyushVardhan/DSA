package com.programming.twopointers.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

//    You are given an array people where people[i] is the weight of the ith person,
//    and an infinite number of boats where each boat can carry a maximum weight of limit.
//    Each boat carries at most two people at the same time, provided the sum of the weight
//    of those people is at most limit.
//
//    Return the minimum number of boats to carry every given person.

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{4,3,3,5}, 5));
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) // matching min weight with max weight to reduce no of boats at end
                i++;
            j--;
        }

        return ans;
    }
}
