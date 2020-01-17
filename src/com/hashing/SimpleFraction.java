package com.hashing;

import java.util.HashMap;
import java.util.Scanner;

public class SimpleFraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-- > 0){
            int num = in.nextInt();
            int den = in.nextInt();
            System.out.println(calculateFraction(num,den));
        }
    }

    static String calculateFraction(int num, int den)
    {
        // If the numerator is zero, answer is 0
        if (num == 0)
            return "0";

        // If any one (out of numerator and denominator)
        // is -ve, sign of resultant answer -ve.
        int sign = (num < 0) ^ (den < 0) ? -1 : 1;

        num = Math.abs(num);
        den = Math.abs(den);

        // Calculate the absolute part (before decimal point).
        int initial = num / den;

        // Output string to store the answer
        String res = "";

        // Append sign
        if (sign == -1)
            res += "-";

        // Append the initial part
        res += initial;

        // If completely divisible, return answer.
        if (num % den == 0)
            return res;

        res += ".";

        // Initialize Remainder
        int rem = num % den;
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Position at which fraction starts repeating
        // if it exists
        int index = 0;
        boolean repeating = false;
        while (rem > 0 && !repeating) {

            // If this remainder is already seen,
            // then there exists a repeating fraction.
            if (mp.get(rem) !=null) {
                // Index to insert parentheses
                index = mp.get(rem);
                repeating = true;
                break;
            }
            else
                mp.put(rem,res.length());

            rem = rem * 10;

            // Calculate quotient, append it to result and
            // calculate next remainder
            int temp = rem / den;
            res += temp;
            rem = rem % den;
        }

        // If repeating fraction exists, insert parentheses.
        if (repeating) {
            String opt = res.substring(index);
            res = res.substring(0,index)+"("+opt+")";
        }

        // Return result.
        return res;
    }
}
