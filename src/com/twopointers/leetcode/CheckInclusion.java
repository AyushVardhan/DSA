package com.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","a"));
    }

    private static boolean checkInclusion(String s1, String s2) {

        String str1 = s1, str2 = s2;
        if (s2.length() < s1.length()) {
            str1 = s2;
            str2 = s1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int count = 0, l = 0;
        for (int r = 0; r < str2.length(); r++) {
            char rc = str2.charAt(r);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc)-1);
                if (map.get(rc)==0) {
                    count++;
                }
            }

            if (count == map.size())
                return true;

            if (r >= str1.length()-1) {
                char lc = str2.charAt(l++);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0)
                        count--;
                    map.put(lc, map.get(lc)+1);
                }
            }
        }

        return false;
    }
}
