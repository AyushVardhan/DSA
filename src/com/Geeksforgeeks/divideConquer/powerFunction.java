package com.Geeksforgeeks.divideConquer;

import java.util.*;
import java.lang.*;

class powerFunction
{
    static int mod = 1000000007;

    // compute reverse of a number
    static long rev(long n)
    {
        long rev_num = 0;
        while(n > 0)
        {
            rev_num = rev_num*10 + n%10;
            n = n/10;
        }
        return rev_num;
    }

    // compute pow(n, rev) with mod 1000000007
    static long modfun(long n, long rev)
    {
        // Base cases
        if (rev == 0)
            return 1;
        if (rev == 1)
            return n;

        // If rev is even, y = (n^(rev/2)) * (n^(rev/2));
        long y = 0;
        if (rev % 2 == 0)
        {
            y = modfun(n, rev / 2);
            y = (y * y) % mod;
        }

        // If rev is odd, y = (n^(rev/2)) * (n^(rev/2)) * n;
        else
        {
            y = ( modfun(n, rev/2) % mod );
            y = ( ( (y * y) % mod ) * n ) % mod;
        }

        return y;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int t= sc.nextInt();
        while(t-- > 0)
        {
            long n = 0;
            n  =sc.nextLong();
            long rev_num = 0;

            // reverse the given number n
            rev_num = rev(n);

            long ans = modfun(n, rev_num);
            System.out.println(ans%mod);
        }
    }
}