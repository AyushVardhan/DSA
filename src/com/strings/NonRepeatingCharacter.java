package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0){
            int len = Integer.parseInt(br.readLine().trim());
            String str1 = br.readLine();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < str1.length(); i++){
                if (map.containsKey(String.valueOf(str1.charAt(i)))){
                    map.put(String.valueOf(str1.charAt(i)),map.get(String.valueOf(str1.charAt(i)))+1);
                }else {
                    map.put(String.valueOf(str1.charAt(i)),1);
                }
            }

            int count = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue()==1){
                    System.out.println(entry.getKey());
                    count = 1;
                    break;
                }
            }

            if (count == 0){
                System.out.println(-1);
            }
        }
    }
}