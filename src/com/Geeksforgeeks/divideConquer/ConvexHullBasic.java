package com.Geeksforgeeks.divideConquer;

import java.util.*;
import java.lang.*;
import java.io.*;

class ConvexHullBasic {
    static int MOD = 1_000_000_007;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();//getInt();
        for (int tt = 0; tt < t; tt++) {
            int N=sc.nextInt();
            // int[]arr=getIntArr();

            Point[]pairs=new Point[N];
            int j=0;
            for(int i=0;i<N;i++){
                pairs[i]=new Point(sc.nextInt(),sc.nextInt());
            }

            Arrays.sort(pairs,new Comp());
            pairs=getUnique(pairs);
            // boolean[]visited=new boolean[N/2];

            // visited[0]=true;
            if(N<3 || isLinear(pairs)){
                System.out.println("-1");
                continue;
            }

            int index=0;
            Set<Integer>set=new HashSet<>();
            set.add(index);
            boolean flag=true;
            while(true){
                ArrayList<Integer>colinear=new ArrayList<>();
                index=getNextLeft(pairs,index,colinear);
                if(set.contains(index)){
                    for(int i:colinear){
                        set.add(i);
                    }
                    break;
                }else{
                    set.add(index);
                }
            }
            ArrayList<Point>res=new ArrayList<>();
            for(int i:set){
                res.add(pairs[i]);
            }
            Collections.sort(res,new Comp());

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<res.size();i++){
                sb.append(res.get(i).toString());
                if(i+1!=res.size()){
                    sb.append(", ");
                }
            }
            System.out.println(sb.toString());
        }
    }
    static Point[] getUnique(Point[]P){
        ArrayList<Point>list=new ArrayList<>();
        int i=0;
        while(i<P.length){
            while(i<P.length-1 && isEqual(P[i],P[i+1])){
                i++;
            }
            list.add(P[i]);
            i++;
        }
        i=0;
        Point[]arr=new Point[list.size()];
        for(Point p:list){
            arr[i++]=p;
        }
        return arr;
    }
    static boolean isEqual(Point p1, Point p2){
        if(p1.x==p2.x && p1.y==p2.y){
            return true;
        }
        return false;
    }
    static boolean isLinear(Point[]P){
        Point O=P[0];
        Point p1=P[1];
        for(int i=2;i<P.length;i++){
            if(isLeft(O,p1,P[i])!=0){
                return false;
            }
        }
        return true;
    }
    static int getNextLeft(Point[]P, int origin, ArrayList<Integer>colinear){
        int index=0;
        while (index==origin){
            index++;
            if(index==P.length){
                index=0;
            }
        }
        Point O=P[origin];
        // =new ArrayList<>();
        Point ref=P[index];
        for(int i=0;i<P.length;i++){
            if(i==origin||i==index){
                continue;
            }
            int temp=isLeft(O,ref,P[i]);
            if(temp==1){
                ref=P[i];
                index=i;
                colinear.clear();//=new ArrayList<>();
            }else if(temp==0){
                if(!isBig(O,ref,P[i])){
                    colinear.add(index);
                    ref=P[i];
                    index=i;
                }else{
                    colinear.add(i);
                }
            }
        }
        return index;
    }
    static boolean isBig(Point O, Point p1, Point p2){
        return (Math.pow(O.x-p1.x,2)+Math.pow(O.y-p1.y,2))>(Math.pow(O.x-p2.x,2)+Math.pow(O.y-p2.y,2));
    }
    static int isLeft(Point O , Point p1, Point p2){
        int x1=p1.x-O.x;
        int y1=p1.y-O.y;

        int x2=p2.x-O.x;
        int y2=p2.y-O.y;

        int mul=x1*y2-x2*y1;
        if(mul>0){
            return 1;
        }else if(mul<0){
            return -1;
        }else{
            return 0;
        }
    }

    static void print(ArrayList<Point> pairs) {
        for (Point p : pairs) {
            System.out.println(p.toString());
        }
        System.out.println();
    }

    static int getInt() throws Exception {
        return Integer.parseInt(br.readLine().toString().trim());
    }

    static int[] getIntArr() throws Exception {
        String s = br.readLine().toString().trim();
        String[] str = s.split(" ");
        int n = str.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    static long[] getLongArr() throws Exception {
        String[] str = br.readLine().toString().trim().split(" ");
        int n = str.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }
    static String[] getStringArr() throws Exception {
        return br.readLine().toString().trim().split(" ");
    }
}

class Dec implements Comparator<Integer> {
    public int compare(Integer p1, Integer p2) {
        return p2 - p1;
    }
}

class Inc implements Comparator<Integer> {
    public int compare(Integer p1, Integer p2) {
        return p1 - p2;
    }
}

class Point {
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return String.format("%d %d",x,y);
    }
}
class Comp implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        if(p1.x==p2.x){
            return p1.y-p2.y;
        }
        return p1.x-p2.x;
    }
}
