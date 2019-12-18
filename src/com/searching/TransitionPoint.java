package com.searching;

import java.util.*;

public class TransitionPoint
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n =sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr,n));
            T--;
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
class GfG
{
    int transitionPoint(int arr[],int n)
    {
        if (arr[0]==1){
            return 1;
        }

        if (arr[n-1]==0){
            return 0;
        }

        int l = 0;
        int h = n-1;
        int mid,result;

        while (true){
            mid = (int) Math.ceil((h + l)/2);
            if (arr[mid]==1 && arr[mid-1]==0){
                result = mid;
                break;
            }

            if (arr[mid]==0){
                l = mid+1;
            }

            if (arr[mid]==1){
                h = mid-1;
            }
        }

        return result;
    }
}