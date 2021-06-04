package com;

import java.util.*;

public class PractiseExampleTwo {

    static private class PairString {
        String first;
        String second;

        PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        List<PairString> list = Arrays.asList(new PairString("item1", "item1"), new PairString("item1", "item1"), new PairString("item1", "item1"));
        System.out.println(LargestItemAssociation(list));
//        System.out.println(LargestItemAssociation_Self(list));
    }

    private static List<String> LargestItemAssociation(List<PairString> itemAssociation) {
        LinkedHashMap<String, LinkedHashSet<String>> map = new LinkedHashMap<>();
        for (PairString pairs : itemAssociation) {
            if (pairs.first.equals(pairs.second)) continue;
            map.computeIfAbsent(pairs.first, val -> new LinkedHashSet<>()).add(pairs.second);
            map.computeIfAbsent(pairs.second, val -> new LinkedHashSet<>()).add(pairs.first);
        }
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            Set<String> visited = new HashSet<>();
            List<String> cur = dfs(name, map, visited);
            if (cur.size() > result.size()) {
                result = cur;
            }
        }
        return result;
    }

    private static List<String> dfs(String name, Map<String, LinkedHashSet<String>> map, Set<String> visited) {
        if (!visited.add(name)) return new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for (String dep : map.get(name)) {
            List<String> next = dfs(dep, map, visited);
            if (next.size() > cur.size()) {
                cur = next;
            }
        }
        visited.remove(name);
        cur.add(0, name);
        return cur;
    }

    private static List<String> LargestItemAssociation_Self(List<PairString> itemAssociation) {
        List<Set<String>> list = new ArrayList<>();
        if (itemAssociation.isEmpty())
            return new ArrayList<>();

        for (PairString pair : itemAssociation) {
            if (list.isEmpty()) {
                Set<String> set = new HashSet<>();
                set.add(pair.second);
                set.add(pair.first);
                list.add(set);
            } else {
                List<Set<String>> tmpList = new ArrayList<>(list);
                boolean found = false;

                for (int i = 0; i < list.size(); i++) {
                    Set st = list.get(i);
                    if (st.contains(pair.first) || st.contains(pair.second)) {
                        st.add(pair.first);
                        st.add(pair.second);
                        found = true;
                    }

                    if (i == list.size()-1 && !found){
                        Set<String> set = new HashSet<>();
                        set.add(pair.second);
                        set.add(pair.first);
                        tmpList.add(set);
                    }
                }
                list = tmpList;
            }
        }

        Set<String> res = new HashSet<>();
        int tmp = Integer.MIN_VALUE;
        for (Set<String> st : list) {
            if (st.size() > tmp) {
                tmp = st.size();
                res = st;
            }
        }

        List<String> resList = new ArrayList<>(res);
        Collections.sort(resList);
        return resList;
    }
}
