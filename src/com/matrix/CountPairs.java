package com.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class CountPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            String[] s = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);


            int[][] arr = new int[n][n];
            int[][] tmp = new int[n][n];
            String[] str = new String[2 * n];

            for (int i = 0; i < 2 * n; i++) {
                str[i] = br.readLine().trim();
            }

            int str_c = 0;
            for (int i = 0; i < n; i++) {
                int k = 0;
                s = str[str_c++].split("\\s+");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(s[k++]);
                }
            }

            HashMap<Integer, Integer> set = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int k = 0;
                s = str[str_c++].split("\\s+");
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = Integer.parseInt(s[k++]);
                    int num = x - tmp[i][j];
                    if (num >= 0) {
                        if (!set.containsKey(num))
                            set.put(num, 1);
                        else
                            set.put(num, set.get(num) + 1);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (set.containsKey(arr[i][j]))
                        count = count + set.get(arr[i][j]);
                }
            }
            System.out.println(count);
        }
    }
}
