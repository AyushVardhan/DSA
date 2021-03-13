package com.Google.hashcode21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PizzaProblem {

    static class PizzaDetail {
        int index;
        List<String> ingredients;

        public PizzaDetail(int index, List<String> ingredients) {
            this.index = index;
            this.ingredients = ingredients;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st1 = br.readLine().trim().split(" ");

        int totalPizza = Integer.parseInt(st1[0]);
        int teamOfTwo = Integer.parseInt(st1[1]);
        int teamOfThree = Integer.parseInt(st1[2]);
        int teamOfFour = Integer.parseInt(st1[3]);
        List<PizzaDetail> pizzaList = new ArrayList<>();

        for (int i = 0; i < totalPizza; i++) {
            st1 = br.readLine().trim().split(" ");
            int size = Integer.parseInt(st1[0]);
            pizzaList.add(new PizzaDetail(i, new ArrayList<>(Arrays.asList(st1).subList(1, size + 1))));
        }

        PriorityQueue<PizzaDetail> max_heap = new PriorityQueue<>((a,b)->Integer.compare(b.ingredients.size(), a.ingredients.size()));
        max_heap.addAll(pizzaList);

        List<PizzaDetail> pizzaQueueList = new ArrayList<>();
        while (!max_heap.isEmpty()) {
            pizzaQueueList.add(max_heap.poll());
        }

        Set<String> ingredientAdded = new HashSet<>();
        HashMap<Integer, Integer> trackMap = new HashMap<>();
        trackMap.put(0,0);
        ingredientAdded.addAll(pizzaQueueList.get(0).ingredients);

        for (int i = 1; i < pizzaQueueList.size(); i++){
            int cnt = 0;
            for (String ingredient : pizzaQueueList.get(i).ingredients){
                if (ingredientAdded.contains(ingredient))
                    cnt++;
            }
            trackMap.put(i,cnt);
            ingredientAdded.addAll(pizzaQueueList.get(i).ingredients);
        }

        HashMap<Integer, Integer> integerIntegerHashMap = sortByValue(trackMap);
        System.out.println();
    }

    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
