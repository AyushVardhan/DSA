package com.mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            if (N % M == 0) {
                System.out.println(N);
            } else {
                int rem = Math.abs(N) % Math.abs(M);
                int ans = 0;

                if(Math.abs(M) - rem <= rem){
                    ans = Math.abs(N) + Math.abs(M) -rem;
                }else {
                    ans = Math.abs(N) - rem;
                }

                if(N < 0){ans = ans * -1;}
                System.out.println(ans);
            }
        }
    }
}
