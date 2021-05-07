package com.Leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitInBasket {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public static int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < tree.length; r++) {
            map.put(tree[r], map.getOrDefault(tree[r],0)+1);

            while (map.size() > 2) {
                map.put(tree[l], map.get(tree[l])-1);
                if (map.get(tree[l]) == 0)
                    map.remove(tree[l]);
                l++;
            }

            res = Math.max(res, r - l +1);
        }

        return res;
    }
}
