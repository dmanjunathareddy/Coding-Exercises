package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
            return -1;
        }
        
        int rows = forest.size();
        int cols = forest.get(0).size();
        
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int height = forest.get(r).get(c);
                if (height > 1) {
                    trees.add(new int[]{height, r, c});
                }
            }
        }
        
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        
        int sr = 0, sc = 0;
        int totalSteps = 0;
        
        for (int[] tree : trees) {
            int tr = tree[1];
            int tc = tree[2];
            int steps = bfs(forest, sr, sc, tr, tc);
            if (steps == -1) {
                return -1;
            }
            totalSteps += steps;
            sr = tr;
            sc = tc;
        }
        
        return totalSteps;
    }
    
    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) {
            return 0;
        }
        
        int rows = forest.size();
        int cols = forest.get(0).size();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && forest.get(nr).get(nc) > 0) {
                        if (nr == tr && nc == tc) {
                            return steps;
                        }
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(0, 0, 4),
            Arrays.asList(7, 6, 5)
        );
        
        CutOffTreesForGolfEvent solution = new CutOffTreesForGolfEvent();
        System.out.println(solution.cutOffTree(forest)); // Example test case
    }
}
