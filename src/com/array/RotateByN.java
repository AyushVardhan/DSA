package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateByN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] sizeOffset = br.readLine().split(" ");
            int size = Integer.parseInt(sizeOffset[0]);
            int n = Integer.parseInt(sizeOffset[1]);
            int arr[] = new int[size];
            int tmp[] = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            for (int i = 0; i < n ; i++){
                tmp[i] = arr[i];
            }
            for (int i = n,j=0; i < size ; i++){
                arr[j++] = arr[i];
            }
            for (int i = size-n,j=0; i<size ; i++){
                arr[i] = tmp[j++];
            }
            for (int i = 0; i < input.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}

/*

#Method 2

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	         Scanner in = new Scanner(System.in);
	         int test = in.nextInt();
	         while(test-->0)
	         {
	             int N = in.nextInt();
	             int D = in.nextInt();
	             int a[]= new int[N];
	             for(int i=0; i<N; i++)
	             {
	                a[i] = in.nextInt();
	             }
	             StringBuffer s = new StringBuffer();
	             for(int i=D; i<N; i++ )
	             {
	                 s.append(a[i]+" ");
	             }
	             for(int i=0;i<D;i++)
	             {
	                 s.append(a[i]+" ");
	             }
	             System.out.println(s);
	         }
	 }
}

#Method3


public class RotateByN {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();

        while (testCase-- > 0) {
            int size = in.nextInt();
            int n = in.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[(i + (size-n))%size] = in.nextInt();
            }
            for (int i = 0 ; i < arr.length ; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}

 */