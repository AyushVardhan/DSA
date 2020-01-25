package com.divideConquer;
import java.util.*;
import java.lang.*;
import java.io.*;

class karatsuba {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cases= Integer.parseInt(br.readLine());
        while(cases-->0)
        {
            String str=br.readLine();
            int value=1;
            StringTokenizer st=new StringTokenizer(str," ");
            while(st.hasMoreTokens())
            {
                int decimal=Integer.parseInt(st.nextToken(),2);
                value*=decimal;
            }
            System.out.println(value);
        }
    }
}