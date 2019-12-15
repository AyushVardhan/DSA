package com.rough;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++){
            arr[i] = in.nextInt();
        }

        int max = 0, count = 0;
        ArrayList<Integer> set = new ArrayList<>();

        for (int i = 0; i< size; i++){
            if (count==3){
                break;
            }
            if (arr[i] > max){
                max = arr[i];
                set.add(max);
                count++;
            }
        }

        if (set.size()==3){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
