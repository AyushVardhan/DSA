package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FloorArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            String[] a1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(a1[0]);
            int x = Integer.parseInt(a1[1]);

            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getVal(arr, 0, n, x));
        }
    }

    private static int getVal(int[] arr, int l, int h, int x) {
        int mid, result;

        if (x < arr[l]) {
            return -1;
        }

        if (x > arr[h-1]){
            return h-1;
        }

        while (true) {
            mid = (int) Math.ceil((l + h) / 2);

            if (arr[mid] == x) {
                result = mid;
                break;
            }

            if (arr[mid] > x && arr[mid - 1] < x) {
                result = mid - 1;
                break;
            }

            if (arr[mid] > x) {
                h = mid;
            }

            if (arr[mid] < x) {
                l = mid;
            }
        }

        return result;
    }
}
