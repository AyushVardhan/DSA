package com.programming.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DFSAndBFSByMatrix {

    public static void main(String[] args) {
        int vertices = 4;
        int[][] adjMtx = new int[][]{{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};

        printDFS(adjMtx, 2);
        System.out.println();
        printBFS(adjMtx, 2);
    }

    private static void printBFS(int[][] adjMtx, int stIdx) {
        int v = adjMtx.length;
        boolean[] vis = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        vis[stIdx] = true;
        queue.add(stIdx);

        while (!queue.isEmpty()) {
            stIdx = queue.poll();
            System.out.print(stIdx + " ");

            for (int i = 0; i < v; i++) {
                if (adjMtx[stIdx][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void printDFS(int[][] adjMtx, int stIdx) {
        boolean[] vis = new boolean[adjMtx.length];
        dfsUtil(adjMtx, vis, stIdx);
    }

    private static void dfsUtil(int[][] adjMtx, boolean[] vis, int stIdx) {
        System.out.print(stIdx + " ");
        vis[stIdx] = true;

        for (int i = 0; i < adjMtx.length; i++) {
            if (adjMtx[stIdx][i] == 1 && !vis[i])
                dfsUtil(adjMtx, vis, i);
        }
    }
}
