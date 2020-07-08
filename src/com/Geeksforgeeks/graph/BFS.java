package com.Geeksforgeeks.graph;

import java.util.*;

public class BFS {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            new Traversal().bfs(0, list, vis, nov);
            System.out.println();
        }
    }
}

class Traversal
{
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
    {
        Queue<Integer> queue = new LinkedList<>();
        vis[s] = true;
        queue.add(s);
        StringBuilder sbd = new StringBuilder();

        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> it = list.get(s).iterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!vis[n])
                {
                    vis[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.print(sbd.toString());
    }
}
