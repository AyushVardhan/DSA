package com.programming;

import java.util.*;

public class PractiseExampleOne {
    public static void main(String[] args) {
        int numCompetitors = 6;
        int topNCompetitors = 2;
        List<String> competitors = Arrays.asList("newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular");
        int numReviews = 6;
        List<String> reviews = Arrays.asList(
                "newshop is providing good services in the city; everyone should use newshop",
                "best services by newshop",
                "fashionbeats has great services in the city",
                "I am proud to have fashionbeats",
                "mymarket has awesome services",
                "Thanks Newshop for the quick delivery"
        );

        Set<String> set = new HashSet<>(competitors);
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Review> queue = new PriorityQueue<>((a,b) -> a.count != b.count ? Integer.compare(b.count, a.count) : a.name.compareTo(b.name));

        for (String str : reviews) {
            for (String st : str.split(" ")) {
                if (set.contains(st))
                    map.put(st, map.getOrDefault(st,0)+1);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            queue.add(new Review((String) entry.getKey(), (int)entry.getValue()));
        }

        for (int i = 0; i < topNCompetitors; i++) {
            Review poll = queue.poll();
            System.out.println(poll.name);
        }

    }

    static private class Review {
        int count;

        public Review(String name, int count) {
            this.count = count;
            this.name = name;
        }

        String name;
    }
}
