package com.twopointers.leetcode;

public class DeliveringBoxesFromStorageInOrder {
    public static void main(String[] args) {
        System.out.println(boxDelivering(new int[][]{{1, 2}, {3, 3}, {3, 1}, {3, 1}, {2, 4}}, 3, 3, 6));

    }

    private static int boxDelivering(int[][] A, int portsCount, int B, int W) {
        int n = A.length, r = 0, nextDiffPort = 0, trips = 0;
        int[] tripsRequiredTillPrevFromThisIdx = new int[n+1];

        for (int l = 0; l < n; l++) {
            while (r < n && B > 0 && W >= A[r][1]) {
                B -= 1;
                W -= A[r][1];
                if (r == 0 || A[r][0] != A[r - 1][0]) {
                    nextDiffPort = r;
                    trips++;
                }

                tripsRequiredTillPrevFromThisIdx[++r] = 200001;
            }

            tripsRequiredTillPrevFromThisIdx[r] = Math.min(tripsRequiredTillPrevFromThisIdx[r], tripsRequiredTillPrevFromThisIdx[l] + trips + 1);
            tripsRequiredTillPrevFromThisIdx[nextDiffPort] = Math.min(tripsRequiredTillPrevFromThisIdx[nextDiffPort], tripsRequiredTillPrevFromThisIdx[l] + trips);

            B += 1;
            W += A[l][1];
            if (l == n - 1 || A[l][0] != A[l + 1][0])
                trips--;
        }

        return tripsRequiredTillPrevFromThisIdx[n];
    }
}
