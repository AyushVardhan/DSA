package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NearestMultipleOf10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            BigInteger num = new BigInteger(br.readLine().trim());
            BigInteger ten = new BigInteger("10");
            BigInteger q,r;

            q = num.divide(ten);
            r = num.remainder(ten);

            if (Integer.parseInt(r.toString()) > 5){
                q = q.add(new BigInteger("1"));
            }

            System.out.println(q.multiply(ten));
        }
    }
}