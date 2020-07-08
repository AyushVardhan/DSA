package com.Geeksforgeeks.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrintKLargestElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int element = in.nextInt();

                if (queue.size() == k) {
                    if (queue.peek() < element) {
                        queue.poll();
                        queue.add(element);
                    }
                } else
                    queue.add(element);
            }

            while (!queue.isEmpty()) {
                list.add(queue.peek());
                queue.poll();
            }

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }

            System.out.println();
        }
    }
}
