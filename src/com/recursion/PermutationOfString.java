package com.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PermutationOfString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            printPermutation(br.readLine().trim());
        }
    }

    private static void printPermutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> stringList = getPermutation(list, str, 0, str.length() - 1);
        Collections.sort(stringList);
        StringBuilder sbr = new StringBuilder();
        for (String st : stringList){
            sbr.append(st).append(" ");
        }
        System.out.println(sbr);
    }

    private static ArrayList<String> getPermutation(ArrayList<String> list, String str, int l, int r) {
        if (l == r) {
            list.add(str);
            return list;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                getPermutation(list, str, l + 1, r);
                str = swap(str, l, i);
            }
        }
        return list;
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
