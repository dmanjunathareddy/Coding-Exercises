package com.softgroup.dsa.graph;

import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Perform topological sort
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, visiting)) {
                    return false; // Cycle detected
                }
            }
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph, int course, boolean[] visited, boolean[] visiting) {
        visiting[course] = true;

        for (int nextCourse : graph.get(course)) {
            if (!visited[nextCourse]) {
                if (visiting[nextCourse] || hasCycle(graph, nextCourse, visited, visiting)) {
                    return true;
                }
            }
        }

        visiting[course] = false;
        visited[course] = true;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        if (canFinish(numCourses, prerequisites)) {
            System.out.println("It is possible to finish all courses.");
        } else {
            System.out.println("It is impossible to finish all courses due to dependency cycle.");
        }
    }
}
