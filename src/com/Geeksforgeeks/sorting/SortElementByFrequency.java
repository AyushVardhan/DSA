package com.Geeksforgeeks.sorting;
// TODO: Sort Hashmap in descending order
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortElementByFrequency {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            sortByFrequency(arr,size);
        }
    }

    private static void sortByFrequency(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer val : arr){
            if (map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else {
                map.put(val,1);
            }
        }

        List<Map.Entry<Integer,Integer>> sortedEntries = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(sortedEntries,
                (e1, e2) -> e2.getValue().compareTo(e1.getValue())
        );

        StringBuilder str = new StringBuilder();

        for (Map.Entry<Integer,Integer> entry : sortedEntries){
            int num = entry.getKey();
            int limit = entry.getValue();
            while (limit-->0){
                str.append(num).append(" ");
            }
        }

        System.out.println(str);
    }
}
