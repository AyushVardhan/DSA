package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 15);
        System.out.println(lists);
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> sol = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        getCombination(num, k, n, 0, sol, res);
        return res;
    }

    private static void getCombination(int[] num, int k, int target, int pos, List<Integer> sol, List<List<Integer>> res) {
        if (pos > num.length)
            return;

        if (target < 0)
            return;

        if (target == 0 && sol.size() == k) {
            res.add(new ArrayList<>(sol));
            return;
        }

        if (sol.size() == k)
            return;

        for (int i = pos; i < num.length; i++){
            sol.add(num[i]);
            if (target - num[i] >= 0){
                getCombination(num, k, target - num[i], i + 1, sol, res);
            }
            sol.remove(sol.size() - 1);
        }
    }
}
