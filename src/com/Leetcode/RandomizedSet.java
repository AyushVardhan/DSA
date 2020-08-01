package com.Leetcode;

import java.util.*;

public class RandomizedSet {
    public static void main(String[] args) {
        Randomized obj = new Randomized();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();

        System.out.println(param_1 + " " + param_2 + " " + param_3);
    }

    static class Randomized {
        Map<Integer, Integer> map;
        List<Integer> list;
        /** Initialize your data structure here. */
        public Randomized() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.isEmpty() || !map.containsKey(val)) return false;

            list.set(map.get(val), list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), map.get(val));

            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random rand = new Random();
            int r = rand.nextInt(list.size());
            return list.get(r);
        }
    }
}
