package com.string;

import java.util.ArrayList;
import java.util.List;

public class AllSubsequence {

    static List<String> al = new ArrayList<>();

    public static void main(String[] args) {
        generateAll("ABCD", "");
        System.out.println(al);
    }

    private static void generateAll(String s, String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }

        generateAll(s.substring(1), ans + s.charAt(0));
        generateAll(s.substring(1), ans);
    }
}
