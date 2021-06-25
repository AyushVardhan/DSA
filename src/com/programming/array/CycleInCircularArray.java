package com.programming.array;

public class CycleInCircularArray {
    public static void main(String[] args) {
        System.out.println(loopExists(new int[]{2, 1, -1, 2}));
    }

    private static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int slow = i, fast = i;
            boolean forwardDirection = arr[i] >= 0;
            do {
                slow = nextIndex(arr, forwardDirection, slow);
                fast = nextIndex(arr, forwardDirection, fast);
                if (fast != -1)
                    fast = nextIndex(arr, forwardDirection, fast);
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int nextIndex(int[] arr, boolean forwardDirection, int i) {
        boolean dir = arr[i] >= 0;
        if (dir != forwardDirection)
            return -1;

        int nextIdx = (i + arr[i]) % arr.length;

        if (nextIdx < 0)
            nextIdx += arr.length;

        if (nextIdx == i)
            nextIdx = -1;

        return nextIdx;
    }
}
