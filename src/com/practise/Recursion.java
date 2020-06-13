package com.practise;

import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            printPattern(n);
            System.out.println();
        }
    }

    private static void printPattern(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            printPattern(n - 5);
            System.out.print(n + " ");
        } else {
            System.out.print(n + " ");
        }
    }
}
