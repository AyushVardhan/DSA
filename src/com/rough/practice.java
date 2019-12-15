package com.rough;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            long N = Long.parseLong(br.readLine());
            int val = 0;
            for (int i=2; i<=Math.sqrt(N); i++){
                if (isPrime(i)){
                    val++;
                }
            }
            System.out.println(val);
        }
    }

    private static boolean isPrime(int num) {
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}