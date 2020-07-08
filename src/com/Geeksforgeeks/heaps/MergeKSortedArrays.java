package com.Geeksforgeeks.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            GfG1 T = new GfG1();
            ArrayList<Integer> arr= T.mergeKArrays(a, n);
            for(int i = 0; i < n*n ; i++)
                System.out.print(arr.get(i)+" ");
            System.out.println();

            t--;
        }
    }
}

class GfG1{

    public static class HeapItem implements Comparable<HeapItem>{
        int[] array;
        int index;
        // the index of current element

        public HeapItem(int[] arr, int index)
        {
            array = arr;
            this.index=index;
        }
        @Override
        public int compareTo(HeapItem h)
        {
            if(array[index] > h.array[h.index])
                return 1;
            else if(array[index] < h.array[h.index])
                return -1;
            else
                return 0;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) {

        // priority queue is heap in Java
        PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();
        // add arrays to the heap
        for (int i = 0; i < arrays.length; i++) {
            pq.add(new HeapItem(arrays[i], 0));
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            HeapItem current = pq.remove();
            result.add(current.array[current.index]);
            if (current.index < current.array.length-1)
            {
                current.index++;
                pq.add(current);
            }
        }
        return result;
    }
}