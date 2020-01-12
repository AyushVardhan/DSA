package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindingDistinctElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            HashMap<Integer,Integer> map = new HashMap<>();
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n*n; i++){
                set.add(ar[i]);
                if (i>0 && (i+1)%n==0){
                    for (Integer num : set){
                        if (map.containsKey(num)){
                            map.put(num,map.get(num)+1);
                        }else{
                            map.put(num,1);
                        }
                    }
                    set.clear();
                }
            }

            int count=0;
            for (Map.Entry<Integer,Integer> mp : map.entrySet()){
                if (mp.getValue()==n){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
