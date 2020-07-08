package com.Geeksforgeeks.heaps;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NearlySortedAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            PriorityQueue<Integer> heap = new PriorityQueue<>();
            if (n >= k) {
                k = n - 1;
            }

            for (int i = 0; i < k + 1; i++)
                heap.add(arr[i]);


            int index = 0;
            for (int i = k + 1; i < n; i++) {
                arr[index++] = heap.peek();
                heap.poll();
                heap.add(arr[i]);
            }

            Iterator<Integer> itr = heap.iterator();
            while (itr.hasNext()) {
                arr[index++] = heap.peek();
                heap.poll();
            }

            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
        }
    }
}
