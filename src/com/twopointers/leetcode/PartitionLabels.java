package com.twopointers.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    private static List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)-'a'] = i;
        }

        int st = 0, lastIdxForChr = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            lastIdxForChr = Math.max(lastIdxForChr, map[s.charAt(i)-'a']);
            if (i == lastIdxForChr) {
                list.add(i - st + 1);
                st = i + 1;
            }
        }

        return list;
    }
}
