package com.graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {
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
                list.get(v).add(u);
            }
            if (new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

class DetectCycle {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0 && checkCycle(i, vis, V, list)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkCycle(int src, int[] vis, int V, ArrayList<ArrayList<Integer>> list) {

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        vis[src] = 1;
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < list.get(u).size(); i++) {
                int v = list.get(u).get(i);

                if (vis[v] == 0) {
                    vis[v] = 1;
                    queue.add(v);
                    parent[v] = u;
                }

                else if (parent[u]!=v){
                    return true;
                }
            }
        }

        return false;
    }
}