package com.Codemonk.complexityAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class VowelRecognition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String input = br.readLine().trim();
            long count = 0;

            Set<String> vowels = new HashSet<>();
            vowels.add("A");
            vowels.add("a");
            vowels.add("E");
            vowels.add("e");
            vowels.add("I");
            vowels.add("i");
            vowels.add("O");
            vowels.add("o");
            vowels.add("U");
            vowels.add("u");

//            int s = 0, e = input.length();
//            while (s != input.length()) {
//                if ((s) < e) {
//                    String substring = input.substring(s, e);
//                    for (int i = 0; i < substring.length(); i++){
//                        if (vowels.contains(String.valueOf(substring.charAt(i)))){
//                            count++;
//                        }
//                    }
//                    e--;
//                } else {
//                    s++;
//                    e = input.length();
//                }
//            }

//            int[] arr = new int[input.length()];
//            for (int i = 0; i < input.length(); i++) {
//                if (i == 0) {
//                    arr[i] = input.length();
//                } else {
//                    arr[i] = (input.length() - i) + arr[i - 1] - i;
//                }
//            }
//
//            for (int i = 0; i < input.length() ; i++){
//                if (vowels.contains(String.valueOf(input.charAt(i)))){
//                    count += arr[i];
//                }
//            }

            for (int i = 0; i < input.length() ; i++){
                if (vowels.contains(String.valueOf(input.charAt(i)))){
                    count = count + ((long)(input.length()-i)*(i+1));
                }
            }


            System.out.println(count);
        }
    }
}
