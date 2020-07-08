package com.Geeksforgeeks.recursion;

import java.util.Scanner;

public class printPattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            pattern(n);
            System.out.println();
        }
    }

    private static void pattern(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            pattern(n - 5);
            System.out.print(n + " ");
        } else {
            System.out.print(n + " ");
        }
    }
}