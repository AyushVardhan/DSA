package com.Geeksforgeeks.graph;

import java.util.*;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new DetectCycleDirected().isCyclic(list, nov))
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

class DetectCycleDirected {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        for (int i = 0; i < V; i++) {
            for (int j : list.get(i)) {
                inDegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int cnt = 0;

        Vector<Integer> top_order = new Vector<>(); //store topological order
        while (!queue.isEmpty()) {
            int u = queue.poll();
            top_order.add(u);

            for (int j : list.get(u)) {
                if (--inDegree[j] == 0) {
                    queue.add(j);
                }
            }

            cnt++;
        }

        if (cnt != V)
            return true;
        else
            return false;
    }
}