package com.softgroup.dsa.interview.leetcode;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class TripsAndUsers {
    static class User {
        int userId;
        String name;
        boolean isActive;

        User(int userId, String name, boolean isActive) {
            this.userId = userId;
            this.name = name;
            this.isActive = isActive;
        }
    }

    static class Trip {
        int tripId;
        int userId;
        String city;
        String startTime;
        String endTime;

        Trip(int tripId, int userId, String city, String startTime, String endTime) {
            this.tripId = tripId;
            this.userId = userId;
            this.city = city;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws ParseException {
        // Example user data
        List<User> users = Arrays.asList(
            new User(1, "Alice", true),
            new User(2, "Bob", false),
            new User(3, "Charlie", true)
        );

        // Example trip data
        List<Trip> trips = Arrays.asList(
            new Trip(101, 1, "New York", "2024-01-01 08:00", "2024-01-01 10:00"),
            new Trip(102, 2, "Los Angeles", "2024-01-02 09:00", "2024-01-02 11:00"),
            new Trip(103, 3, "Chicago", "2024-01-03 07:00", "2024-01-03 09:00"),
            new Trip(104, 1, "Miami", "2024-01-04 08:30", "2024-01-04 12:00")
        );

        List<String> result = getTripsAndUsers(trips, users);
        for (String record : result) {
            System.out.println(record);
        }
    }

    public static List<String> getTripsAndUsers(List<Trip> trips, List<User> users) throws ParseException {
        Map<Integer, User> userMap = new HashMap<>();
        for (User user : users) {
            userMap.put(user.userId, user);
        }

        List<String> result = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Trip trip : trips) {
            User user = userMap.get(trip.userId);
            if (user != null && user.isActive) {
                String record = "Trip ID: " + trip.tripId + ", User: " + user.name + ", City: " + trip.city +
                                ", Start Time: " + trip.startTime + ", End Time: " + trip.endTime +
                                ", Duration: " + getDuration(trip.startTime, trip.endTime, dateFormat) + " minutes";
                result.add(record);
            }
        }
        return result;
    }

    private static long getDuration(String startTime, String endTime, SimpleDateFormat dateFormat) throws ParseException {
        Date start = dateFormat.parse(startTime);
        Date end = dateFormat.parse(endTime);
        long duration = (end.getTime() - start.getTime()) / (60 * 1000);  // Duration in minutes
        return duration;
    }
}
