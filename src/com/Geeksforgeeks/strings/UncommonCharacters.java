package com.Geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class UncommonCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        while (tests-- > 0) {
            String str1 = br.readLine();
            String str2 = br.readLine();

            TreeSet<String> set1 = new TreeSet<>();
            TreeSet<String> set2 = new TreeSet<>();
            TreeSet<String> result = new TreeSet<>();

            for (int i = 0; i < str1.length(); i++) {
                set1.add(String.valueOf(str1.charAt(i)));
            }

            for (int i = 0; i < str2.length(); i++) {
                set2.add(String.valueOf(str2.charAt(i)));
            }

            Iterator<String> itr = getIterator(set1);
            while (itr.hasNext()){
                String next = itr.next();
                if (!set2.contains(next)){
                    result.add(next);
                }
            }

            itr = getIterator(set2);
            while (itr.hasNext()){
                String next = itr.next();
                if (!set1.contains(next)){
                    result.add(next);
                }
            }

            itr = getIterator(result);
            while (itr.hasNext()){
                System.out.print(itr.next());
            }
            System.out.println();
        }
    }

    private static Iterator<String> getIterator(TreeSet<String> set) {
        return set.iterator();
    }
}
