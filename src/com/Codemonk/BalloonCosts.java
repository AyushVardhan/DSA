package com.Codemonk;

import java.util.Scanner;

public class BalloonCosts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int cOne = in.nextInt();
            int cTwo = in.nextInt();

            int students = in.nextInt();
            int cOneCount = 0;
            int cTwoCount = 0;

            for (int i = 0; i < students; i++) {
                int q1 = in.nextInt();
                int q2 = in.nextInt();

                if (q1 == 1) {
                    cOneCount++;
                }

                if (q2 == 1) {
                    cTwoCount++;
                }
            }

            int minCost, maxCost;
            if (cOne > cTwo) {
                minCost = cTwo;
                maxCost = cOne;
            } else {
                minCost = cOne;
                maxCost = cTwo;
            }

            if (cOneCount > cTwoCount) {
                System.out.println(cTwoCount * maxCost + cOneCount * minCost);
            } else {
                System.out.println(cTwoCount * minCost + cOneCount * maxCost);
            }
        }
    }
}
