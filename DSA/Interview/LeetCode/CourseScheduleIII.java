package com.softgroup.dsa.interview.leetcode;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                pq.offer(course[0]);
                time += course[0];
            } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                time += course[0] - pq.poll();
                pq.offer(course[0]);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        CourseScheduleIII solution = new CourseScheduleIII();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(solution.scheduleCourse(courses)); // Output: 3
    }
}
