package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ItemGroupSorter {
    public static List<Integer> sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step 1: Adjust group numbers for unassigned items
        int newGroupId = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = newGroupId++;
            }
        }

        // Step 2: Initialize adjacency lists and indegree arrays
        List<Integer>[] itemGraph = new List[n];
        List<Integer>[] groupGraph = new List[newGroupId];
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[newGroupId];
        for (int i = 0; i < n; i++) {
            itemGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < newGroupId; i++) {
            groupGraph[i] = new ArrayList<>();
        }

        // Step 3: Build graphs and indegree arrays
        for (int i = 0; i < n; i++) {
            int currentGroup = group[i];
            for (int before : beforeItems.get(i)) {
                int beforeGroup = group[before];
                // Add dependency to item graph
                itemGraph[before].add(i);
                itemIndegree[i]++;
                // Add dependency to group graph if different groups
                if (currentGroup != beforeGroup) {
                    groupGraph[beforeGroup].add(currentGroup);
                    groupIndegree[currentGroup]++;
                }
            }
        }

        // Step 4: Topological sort on groups and items
        List<Integer> sortedGroups = topologicalSort(groupGraph, groupIndegree);
        List<Integer> sortedItems = topologicalSort(itemGraph, itemIndegree);

        // If either list is empty, there's a cycle
        if (sortedGroups.isEmpty() || sortedItems.isEmpty()) {
            return new ArrayList<>();
        }

        // Step 5: Group the items according to the sorted groups
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : sortedItems) {
            groupToItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // Step 6: Concatenate the items respecting the group order
        List<Integer> result = new ArrayList<>();
        for (int grp : sortedGroups) {
            if (groupToItems.containsKey(grp)) {
                result.addAll(groupToItems.get(grp));
            }
        }

        return result;
    }

    private static List<Integer> topologicalSort(List<Integer>[] graph, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Initialize the queue with nodes with zero indegree
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process the nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If the result size doesn't match the number of nodes, there's a cycle
        return result.size() == graph.length ? result : new ArrayList<>();
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = Arrays.asList(
            Collections.emptyList(),
            Arrays.asList(6),
            Arrays.asList(5),
            Arrays.asList(6),
            Arrays.asList(3, 6),
            Collections.emptyList(),
            Collections.emptyList(),
            Collections.emptyList()
        );

        List<Integer> result = sortItems(n, m, group, beforeItems);
        System.out.println(result); // Expected: [6, 3, 4, 5, 2, 0, 7, 1]
    }
}
