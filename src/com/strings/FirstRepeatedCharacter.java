package com.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstRepeatedCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0){
            String str = br.readLine();
            int[] a = new int[26];
            int index, count = 0;

            for (int i = 0; i<str.length(); i++){
                index = str.charAt(i)-'a';
                a[index]++;

                if (a[index]>1){
                    System.out.println(str.charAt(i));
                    break;
                }else {
                    count = count + 1;
                }
            }

            if (count == str.length()){
                System.out.println(-1);
            }
        }
    }
}
