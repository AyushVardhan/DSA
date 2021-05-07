package com.Leetcode.twopointer;

public class CircularArrayLoop {
    public static void main(String[] args) {
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }

    private static boolean circularArrayLoop(int[] num) {
        int n = num.length;
        int[] loop = new int[n];
        int loopIdx = 1;

        for (int i = 0; i < n; i++) {
            int cur = i;
            if (loop[cur] == 0) {
                loop[cur] = loopIdx;
                while (true){
                    int next = getNext(num, cur);
                    if (cur == next || num[cur] * num[next] < 0)
                        break;

                    if (loop[next] == loopIdx)
                        return true;

                    loop[next] = loopIdx;
                    cur = next;
                }
                loopIdx++;
            }
        }

        return false;
    }

    private static int getNext(int[] num, int cur) {
        int next = cur + num[cur];
        while (next < 0) {
            next += num.length;
        }

        return next % num.length;
    }


}
