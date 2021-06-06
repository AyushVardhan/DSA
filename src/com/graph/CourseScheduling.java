package com.graph;

import java.util.*;

public class CourseScheduling {
    public static void main(String[] args) {
        int[][] courses = new int[][]{{1,2},{},{0,1}};
        System.out.println(solve(courses));
    }

    private static boolean solve(int[][] courses) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        int[] indeg = new int[courses.length];

        for (int i = 0; i < courses.length; i++) {
            List<Integer> prereq;

            for (int neighbour : courses[i]) {
                prereq = prereqMap.getOrDefault(neighbour, new ArrayList<>());
                prereq.add(i);
                indeg[i]++;
                prereqMap.put(neighbour, prereq);
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < courses.length; i++) {
            if (indeg[i] == 0)
                que.add(i);
        }

        int count = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (indeg[cur] == 0) {
                count++;
            }

            if (!prereqMap.containsKey(cur)) {
                continue;
            }

            for (int neighbor : prereqMap.get(cur)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0)
                    que.add(neighbor);
            }
        }

        return count == courses.length;
    }
}
