package com.programming.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSAndBFSByList {

    private static void addEdge(List<List<Integer>> adjList, int st, int end) {
        adjList.get(st).add(end);
    }

    private static List<List<Integer>> getAdjancencyListsForGraph(int vertices) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(i, new ArrayList<>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 4);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 0);
        addEdge(adjList, 2, 1);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 2);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 1);
        addEdge(adjList, 4, 3);
        return adjList;
    }

    public static void main(String args[]) {
        int vertices = 5;
        List<List<Integer>> adjList = getAdjancencyListsForGraph(vertices);

        printDFSByList(adjList, 2);
        System.out.println();
        printBFSByList(adjList, 2);
    }

    private static void printBFSByList(List<List<Integer>> adjList, int stIdx) {
        boolean[] vis = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(stIdx);
        vis[stIdx] = true;

        while (!queue.isEmpty()) {
            stIdx = queue.poll();
            System.out.print(stIdx + " ");

            for (int adj : adjList.get(stIdx)) {
                if (!vis[adj]){
                    vis[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    private static void printDFSByList(List<List<Integer>> adjList, int startIdx) {
        boolean[] vis = new boolean[adjList.size()];
        dfsUtilList(adjList, vis, startIdx);
    }

    private static void dfsUtilList(List<List<Integer>> adjList, boolean[] vis, int startIdx) {
        vis[startIdx] = true;
        System.out.print(startIdx + " ");

        for (int adjVtx : adjList.get(startIdx)) {
            if (!vis[adjVtx]) {
                dfsUtilList(adjList, vis, adjVtx);
            }
        }
    }
}
