package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while (tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            HashMap<HashSet<Character>, Integer> countMap = new HashMap<>();
            for (String str : arr) {
                Character[] chars = new Character[str.length()];
                int i = 0;
                for (Character chr : str.toCharArray()) {
                    chars[i++] = chr;
                }

                HashSet<Character> set = new HashSet<>(Arrays.asList(chars));
                if (countMap.containsKey(set)) {
                    countMap.put(set, countMap.get(set) + 1);
                } else {
                    countMap.put(set, 1);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<HashSet<Character>, Integer> map : countMap.entrySet()) {
                list.add(map.getValue());
            }

            Collections.sort(list);
            StringBuilder str = new StringBuilder();
            for (Integer nm : list){
                str.append(nm).append(" ");
            }

            System.out.println(str);
        }
    }
}
