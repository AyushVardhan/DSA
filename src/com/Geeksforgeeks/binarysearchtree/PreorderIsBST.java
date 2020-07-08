package com.Geeksforgeeks.binarysearchtree;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PreorderIsBST {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            int a[] = new int[n];
            for (int i = 0 ; i < n ; i++){
                a[i] = in.nextInt();
            }

            Stack<Integer> stk = new Stack<>();
            int root = Integer.MIN_VALUE;
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < root) {
                    System.out.println(0);
                    flag = 1;
                    break;
                }

                while (!stk.isEmpty() && stk.peek() < a[i]) {
                    root = stk.peek();
                    stk.pop();
                }

                stk.push(a[i]);
            }

            if (flag == 0)
                System.out.println(1);
        }
    }
}
