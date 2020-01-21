package com.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveAdjacentDuplicate {
    public static String removeadjdup(String s) {
        int l = s.length();
        StringBuilder sbr = new StringBuilder();
        int i = 0, j = 0;
        boolean flag = false;
        while (i < s.length()) {
            flag = false;
            j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                flag = true;
                j++;
            }
            if (!flag)
                sbr.append("" + s.charAt(i));
            i = j;
        }
        if (sbr.length() == l)
            return sbr.toString();
        else
            return removeadjdup(sbr.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String str;
        while (t-- > 0) {
            str = br.readLine();
            System.out.println(removeadjdup(str));
        }
    }
}