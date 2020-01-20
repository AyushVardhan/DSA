package com.recursion;

import java.util.Scanner;

public class Handshakes_Catalan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            System.out.println(handshakes(n));
        }
    }

    private static int handshakes(int n) {
        int sum = 0;
        if (n == 2 || n == 0) {
            return 1;
        } else {
            for (int i = 2; i <= n; i = i + 2)
                sum += handshakes(n - i) * handshakes(i - 2);
        }
        return sum;
    }
}
