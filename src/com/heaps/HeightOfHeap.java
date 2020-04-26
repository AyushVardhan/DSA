package com.heaps;

import java.util.Scanner;

public class HeightOfHeap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int test = in.nextInt();
        while (test-- > 0){
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n ; i++){
                arr[i] = in.nextInt();
            }

            System.out.println((int)Math.ceil(Math.log(n + 1) / Math.log(2)) - 1);
        }
    }
}
