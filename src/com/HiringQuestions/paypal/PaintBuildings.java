package com.HiringQuestions.paypal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PaintBuildings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int[] s = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = s[0];
            int M = s[1];
            int K = s[2];
            int[] house = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int houseCost[][] = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    houseCost[i][j] = in.nextInt();
                }
            }

            Set<Integer> colored = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (house[i] != 0) {
                    colored.add(i);
                }
            }

            if (colored.size() > 0) {
                if (colored.size() > 1 && K == 1) {
                    System.out.println(-1);
                } else if (colored.size() == 1 && K == 1) {

                    Integer n = 0;
                    for (Integer integer : colored) {
                        n = integer;
                        break;
                    }

                    int color = house[n], sum = 0;
                    for (int i = 0; i < N; i++) {
                        if (!colored.contains(i))
                            sum += houseCost[i][color - 1];
                    }

                    System.out.println(sum);

                } else {
                    int currSpecialty = getSpeciality(house);
                    System.out.println("currSpecialty : " + currSpecialty);
                }
            } else {
                int currSpecialty = getSpeciality(house);
                System.out.println("currSpecialty : " + currSpecialty);
            }
        }
    }

    private static int getSpeciality(int[] house) {
        int k = 1;
        for (int i = 1; i < house.length; i++) {
            if (house[i] != house[i + 1])
                k++;
        }
        return k;
    }
}
