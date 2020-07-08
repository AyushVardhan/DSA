package com.Codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().trim();
        String[] strArr = str.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            stringBuilder.append(strArr[i]);
        }

        if (str.equals(stringBuilder.toString()))
            System.out.println("YES");
        else System.out.println("NO");
    }
}
