package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SmallestWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if (str2.length() > str1.length()){
            System.out.println(-1);
        }else if (str2.length() == str1.length()){
            if (str2.equals(str1)){
                System.out.println(str2);
            }else {
                System.out.println(-1);
            }
        }else {
            HashMap<Integer, Character> map = new HashMap<>();
            for (int i=0; i < str1.length(); i++){
                map.put(i, str1.charAt(i));
            }

            for (int i =0; i < str2.length(); i++){
                for (int j = 0; j < str1.length(); j++){

                }
            }
        }
    }
}
