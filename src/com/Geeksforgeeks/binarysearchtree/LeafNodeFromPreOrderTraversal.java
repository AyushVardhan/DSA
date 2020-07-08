package com.Geeksforgeeks.binarysearchtree;

import java.util.Scanner;
import java.util.Stack;

public class LeafNodeFromPreOrderTraversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            getLeafs(n, arr);
            System.out.println();
        }
    }

    private static void getLeafs(int n, int[] arr) {
        Stack<Integer> stk = new Stack<>();
        boolean flag;
        for (int i = 0, j = 1; j < n; i++, j++) {
            flag = false;

            if (arr[i] > arr[j])
                stk.push(arr[i]);
            else {
                while (!stk.isEmpty()){
                    if (stk.peek() < arr[j]){
                        stk.pop();
                        flag = true;
                    }else
                        break;
                }
            }

            if (flag)
                System.out.print(arr[i] + " ");
        }

        System.out.print(arr[n - 1]);
    }
}