package com.codemonk.complexityAnalysis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ASumB {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = br.readLine();

            if (input == null || input.equals(""))
                break;

            String[] s = input.trim().split(" ");
            BigInteger n1 = new BigInteger(s[0]);
            BigInteger n2 = new BigInteger(s[1]);
            System.out.println(n1.add(n2).toString());
        }
    }
}
