package com.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//ON GFG, its wrong
public class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int res[] = new int[10001];
            res = new TopolSort().topoSort(list, nov);
            boolean valid = true;

            for (int i = 0; i < nov; i++) {
                int n = list.get(res[i]).size();
                for (int j = 0; j < list.get(res[i]).size(); j++) {
                    for (int k = i + 1; k < nov; k++) {
                        if (res[k] == list.get(res[i]).get(j)) n--;
                    }
                }
                if (n != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid == true)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

class TopolSort{
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
        boolean visited[] = new boolean[10001];
        Arrays.fill(visited, false);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
                topologicalSortUtil(list, i, visited,
                        st);
        }
        int A[] = new int[st.size()];
        int i = -1;
        while (!st.isEmpty())
        {
            A[++i] = st.peek();
            st.pop();
        }

        return A;
    }

    static void topologicalSortUtil(ArrayList<ArrayList<Integer>> list, int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = list.get(v).iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(list, i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }
}