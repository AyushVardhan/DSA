package com.Leetcode;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int arr[] = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(combinationSum(arr,target));;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        getCombinations(candidates,target,finalList,list,0);
        return finalList;
    }

    private static void getCombinations(int[] candidates, int target, List<List<Integer>> finalList, LinkedList<Integer> list, int i) {
        if (target < 0)
            return;
        if (target == 0){
            finalList.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j-1]) continue;

            list.add(candidates[j]);
            getCombinations(candidates,target-candidates[j], finalList, list, j+1);
            list.removeLast();
        }
    }
}
