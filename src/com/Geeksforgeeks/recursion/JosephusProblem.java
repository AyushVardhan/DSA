package com.Geeksforgeeks.recursion;

import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(josephus(n, k));
        }
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
}
