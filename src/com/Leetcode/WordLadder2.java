package com.Leetcode;

import java.util.*;

public class WordLadder2 {

    /*
                Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

                Only one letter can be changed at a time
                Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
                Note:

                Return an empty list if there is no such transformation sequence.
                All words have the same length.
                All words contain only lowercase alphabetic characters.
                You may assume no duplicates in the word list.
                You may assume beginWord and endWord are non-empty and are not the same.
                Example 1:

                Input:
                beginWord = "hit",
                endWord = "cog",
                wordList = ["hot","dot","dog","lot","log","cog"]

                Output:
                [
                  ["hit","hot","dot","dog","cog"],
                  ["hit","hot","lot","log","cog"]
                ]
                Example 2:

                Input:
                beginWord = "hit"
                endWord = "cog"
                wordList = ["hot","dot","dog","lot","log"]

                Output: []

                Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    public static void main(String[] args) {
        List<List<String>> ladders = findLadders("hit", "cit", Arrays.asList("hot", "cot", "dot", "cit", "dit"));
        for (List<String> lst : ladders) {
            for (String str : lst) {
                System.out.print(" " + str + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private static void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private static void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}


/* Can also done as:

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);
        HashMap<String, List<String>> map = new HashMap<>();
        bfs(map, set1, set2, dict, false);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(res, path, map, beginWord, endWord);
        return res;
    }

    private void bfs(HashMap<String, List<String>> map, HashSet<String> set1, HashSet<String> set2, HashSet<String> dict, boolean flip){
        if(set1.isEmpty()){
            return;
        }

        if(set1.size() > set2.size()){
            bfs(map, set2, set1, dict, !flip);
            return;
        }

        boolean done = false;
        dict.removeAll(set1);
        dict.removeAll(set2);

        HashSet<String> next = new HashSet<>();
        for(String str : set1){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char temp = chs[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(chs[i] != ch){
                        chs[i] = ch;
                        String word = new String(chs);

                        String key = flip ? word : str;
                        String val = flip ? str : word;

                        List<String> list = map.get(key) == null ? new ArrayList<>() : map.get(key);

                        if(set2.contains(word)){
                            done = true;

                            list.add(val);
                            map.put(key, list);
                        }

                        if(!done && dict.contains(word)){
                        	next.add(word);

                            list.add(val);
                            map.put(key, list);
                        }
                    }
                }
                chs[i] = temp;
            }
        }

        if(!done){
            bfs(map, set2, next, dict, !flip);
        }
    }

    private void dfs(List<List<String>> res, List<String> path, HashMap<String, List<String>> map, String start, String end){
        if(start.equals(end)){
            res.add(new ArrayList<>(path));
            return;
        }

        if(!map.containsKey(start)){
            return;
        }

        for(String next : map.get(start)){
            path.add(next);
            dfs(res, path, map, next, end);
            path.remove(path.size() - 1);
        }
    }
}

 */