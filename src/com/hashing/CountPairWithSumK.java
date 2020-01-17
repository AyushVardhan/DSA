package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountPairWithSumK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int test = Integer.parseInt(br.readLine().trim());

        while (test-- > 0) {
            int[] s = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int k = s[1];

            HashMap<Integer,Integer> map = new HashMap<>();
            for (Integer num : ar){
                if (!map.containsKey(num))
                    map.put(num,1);
                else
                    map.put(num,map.get(num)+1);
            }

            int count=0;
            for (Integer num : ar){
                if (map.get(k-num)!=null){
                    count += map.get(k-num);
                }

                if (num == k-num){
                    count--;
                }
            }

            System.out.println(count/2);
        }
    }
}