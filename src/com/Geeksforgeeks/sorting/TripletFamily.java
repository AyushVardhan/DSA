package com.Geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletFamily {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(getList(size, arr));
            ;
        }
    }

    private static int getList(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (Integer num :
                arr) {
            set.add(num);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (set.contains(arr[i] + arr[j])) {
                    count++;
                }
            }
        }

        return count == 0 ? -1 : count;
    }
}
