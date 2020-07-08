package com.Geeksforgeeks.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            toh(n, 1, 3, 2);
            System.out.println((int)Math.pow(2,n)-1);
        }
    }

    static void toh(int n, int from, int to, int aux)
    {
        if(n==1)
        {    System.out.println("move disk "+ n + " from rod "+from+ " to rod "+to);
            return;

        }

        toh(n-1,from,aux,to);

        System.out.println("move disk "+ n+ " from rod "+ from+ " to rod "+ to);
        toh(n-1,aux,to,from);

    }
}
