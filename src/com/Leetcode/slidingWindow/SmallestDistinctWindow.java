package com.Leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestDistinctWindow {
    public static void main(String[] args) {
        System.out.println(findSubString("GEEKSGEEKSFOR"));
    }

    private static String findSubString( String str) {
        // Your code goes here
        int count = getUniqueCount(str);
        int l =0;
        int resLength = Integer.MAX_VALUE;
        int startCh = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < str.length(); r++) {
            char rc = str.charAt(r);
            map.put(rc, map.getOrDefault(rc,0)+1);

            while (count == map.size()) {
                if (resLength > r - l + 1){
                    resLength = r - l + 1;
                    startCh = l;
                }

                char lc = str.charAt(l++);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0){
                    map.remove(lc);
                }
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : str.substring(startCh, startCh + resLength);
    }

    private static int getUniqueCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        return map.size();
    }
}
