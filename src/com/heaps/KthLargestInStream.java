package com.heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInStream {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int k = in.nextInt();
            int n = in.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            StringBuilder sbr = new StringBuilder();

            for (int i = 0; i < k - 1; i++) {
                queue.add(arr[i]);
                sbr.append("-1 ");
            }

            queue.add(arr[k - 1]);
            sbr.append(queue.peek()+" ");
            for (int i = k; i < n; i++) {
                if (arr[i] > queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
                sbr.append(queue.peek() + " ");
            }
            System.out.println(sbr.toString());
        }
    }
}
