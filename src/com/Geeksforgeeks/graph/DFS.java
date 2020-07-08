package com.Geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            new Traversal_NonRecursive().dfs(0, list, vis);
            System.out.println();
        }
    }
}

class Traversal_NonRecursive
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {

//        Without stack i.e Recursive Approach
        vis[src]=true;
        System.out.print(src + " ");
        for(int i=0;i<list.get(src).size();i++)
        {
            if(!vis[list.get(src).get(i)])
                dfs(list.get(src).get(i),list,vis);
        }

        //Using Stack
//        Stack<Integer> stk = new Stack<>();
//        stk.push(src);
//
//        while (!stk.isEmpty()){
//            src = stk.pop();
//            if (!vis[src]){
//                vis[src] = true;
//                System.out.print(src+" ");
//            }
//
//            Iterator<Integer> itr = list.get(src).iterator();
//            while (itr.hasNext()){
//                int n = itr.next();
//                if (!vis[n])
//                {
//                    stk.push(n);
//                }
//            }
//        }
    }
}