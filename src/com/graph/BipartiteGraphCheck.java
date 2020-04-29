package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraphCheck {
    //This will run for disconnected graph as well, otherwise only for connected graph, we dont need for look to call check
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int V = sc.nextInt();
            int[][] G = new int[V][V];
            for(int i = 0; i < V; i++)
                for(int j = 0; j < V; j++)
                    G[i][j] = sc.nextInt();
            bip b = new bip();
            if (b.isBipartite(G, V))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}

class bip{
    int v;
    boolean isBipartite(int G[][],int V)
    {
        this.v = V;
        int color[] = new int[v];
        Arrays.fill(color,-1);

        for (int i = 0; i < v; i++){
            if (color[i]==-1 && !check(G, i, color))
                return false;
        }

        return true;
    }

    private boolean check(int[][] g, int src,int color[]) {

        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int u = queue.poll();

            if (g[u][u]==1)
                return false;

            for (int i = 0; i < v; i++){
                if (g[u][i]==1 && color[i]==-1){
                    color[i] = 1-color[u];
                    queue.add(i);
                }

                if (g[u][i]==1 && color[i]==color[u])
                    return false;
            }
        }

        return true;
    }
}