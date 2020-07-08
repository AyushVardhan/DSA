package com.Geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAdjacencyList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {

            int v = in.nextInt();
            int e = in.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < v; i++){
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++){
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                list.get(v1).add(v2);
                list.get(v2).add(v1);
            }

            for (int i =0; i<list.size(); i++){
                System.out.print(i);
                for (int j = 0; j < list.get(i).size(); j++){
                    System.out.print("-> "+list.get(i).get(j));
                }
                System.out.println();
            }
        }
    }
}

// if vertices not in 0,1,2,.. sequence:
//HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
//
//            if (e == 0) {
//                    for (int i =0; i < v;i++){
//        System.out.println(i);
//        }
//        continue;
//        }
//
//        for (int i = 0; i < e; i++){
//        int v1 = in.nextInt();
//        int v2 = in.nextInt();
//
//
//        if (map.containsKey(v2)){
//        map.get(v2).add(v1);
//        }else {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(v1);
//        map.put(v2, list);
//        }
//
//        if (map.containsKey(v1)){
//        map.get(v1).add(v2);
//        }else {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(v2);
//        map.put(v1, list);
//        }
//        }
//
//        ArrayList<Integer> tmp;
//        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
//        System.out.print(entry.getKey());
//        tmp = entry.getValue();
//
//        for (int i = 0; i < tmp.size(); i++){
//        System.out.print("-> "+tmp.get(i));
//        }
//        System.out.println();
//        }
