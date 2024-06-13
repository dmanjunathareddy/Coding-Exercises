package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return results;
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();

        wordSet.add(beginWord);

        bfs(beginWord, endWord, wordSet, graph, distances);
        dfs(beginWord, endWord, graph, distances, new ArrayList<>(), results);

        return results;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distances) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);

            List<String> neighbors = getNeighbors(current, wordSet);
            for (String neighbor : neighbors) {
                graph.computeIfAbsent(current, k -> new ArrayList<>()).add(neighbor);
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    queue.offer(neighbor);
                }
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = oldChar;
        }

        return neighbors;
    }

    private void dfs(String current, String endWord, Map<String, List<String>> graph, Map<String, Integer> distances, List<String> path, List<List<String>> results) {
        path.add(current);

        if (current.equals(endWord)) {
            results.add(new ArrayList<>(path));
        } else {
            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    if (distances.get(neighbor) == distances.get(current) + 1) {
                        dfs(neighbor, endWord, graph, distances, path, results);
                    }
                }
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        WordLadderII solution = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> results = solution.findLadders(beginWord, endWord, wordList);
        for (List<String> path : results) {
            System.out.println(path);
        }
    }
}
