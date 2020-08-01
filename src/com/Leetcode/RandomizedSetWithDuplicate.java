package com.Leetcode;

import java.util.*;

public class RandomizedSetWithDuplicate {
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        int param_3 = obj.getRandom();

        System.out.println(param_1 + " " + param_2 + " " + param_3);
    }

    static class RandomizedCollection {

        List<Integer> list;
        Map<Integer, List<Integer>> map;
        Random rand;

        public RandomizedCollection() {
            map = new HashMap();
            list = new ArrayList();
            rand = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean exist = map.containsKey(val);

            list.add(val);

            List<Integer> mapItem = map.getOrDefault(val, new ArrayList());
            mapItem.add(list.size()-1);
            map.put(val, mapItem);

            return !exist;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            List<Integer> currentMapList = map.get(val);
            if(currentMapList == null) return false;

            list.set(currentMapList.get(0), null);
            currentMapList.remove(0);
            if(currentMapList.size() == 0) map.remove(val);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int random = rand.nextInt(list.size());
            while(list.get(random) == null){
                random = rand.nextInt(list.size());
            }
            return list.get(random);
        }
    }
}
