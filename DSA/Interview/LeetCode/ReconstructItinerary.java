package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flights.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK", flights, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> flights, LinkedList<String> result) {
        PriorityQueue<String> nextAirports = flights.get(airport);

        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll(), flights, result);
        }

        result.addFirst(airport);
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );

        System.out.println(ri.findItinerary(tickets)); // Output: [JFK, MUC, LHR, SFO, SJC]
    }
}
