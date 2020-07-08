package com.Codemonk;

import java.util.Scanner;

public class FindProduct {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long ans = 1;

        for (int i = 0; i < n; i++) {
            long nm = in.nextLong();
            ans = (ans * nm) % 1000000007;
        }

        System.out.println(ans);
    }
}
