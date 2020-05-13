package com.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] st1 = br.readLine().trim().split("");
            HashMap<String, Integer> map1 = new HashMap<>();
            for (String str : st1) {
                if (map1.containsKey(str)) {
                    map1.put(str, map1.get(str) + 1);
                } else {
                    map1.put(str, 1);
                }
            }

            String[] st2 = br.readLine().trim().split("");
            HashMap<String, Integer> map2 = new HashMap<>();
            for (String str : st2) {
                if (map2.containsKey(str)) {
                    map2.put(str, map2.get(str) + 1);
                } else {
                    map2.put(str, 1);
                }
            }

            int charCount = 0;
            for (String str : st1){
                if (map2.containsKey(str) && map2.get(str)!=0){
                    map2.put(str,map2.get(str)-1);
                }else {
                    charCount++;
                }
            }

            for (String str : st2){
                if (map1.containsKey(str) && map1.get(str)!=0){
                    map1.put(str,map1.get(str)-1);
                }else {
                    charCount++;
                }
            }

            System.out.println(charCount);
        }
    }
}
