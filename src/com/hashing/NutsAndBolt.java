package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NutsAndBolt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        Set<String> set = new LinkedHashSet<>();
        set.add("!");
        set.add("#");
        set.add("$");
        set.add("%");
        set.add("&");
        set.add("*");
        set.add("@");
        set.add("^");
        set.add("~");

        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] nuts = br.readLine().trim().split(" ");
            String[] bolts = br.readLine().trim().split(" ");

            Set<String> nutSet = new HashSet<>(Arrays.asList(nuts));

            StringBuilder strb = new StringBuilder();
            for (String str : set){
                if (nutSet.contains(str)){
                    strb.append(str).append(" ");
                }
            }

            strb.append("\n").append(strb);
            System.out.println(strb);
        }
    }
}
