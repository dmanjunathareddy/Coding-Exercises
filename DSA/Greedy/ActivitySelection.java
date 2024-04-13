package com.softgroup.dsa.greedy;

import java.util.*;

class Activity {
	int start, end;

	Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class ActivitySelection {

	public static List<Activity> selectActivities(List<Activity> activities) {
		// Sort activities by end time (earliest ending first)
		Collections.sort(activities, Comparator.comparingInt(a -> a.end));

		List<Activity> selectedActivities = new ArrayList<>();
		// Initialize the end time of the last selected activity as a very early time
		int lastEndTime = Integer.MIN_VALUE;

		// Iterate through the sorted activities
		for (Activity activity : activities) {
			// If the current activity starts after the last selected activity ends
			if (activity.start >= lastEndTime) {
				// Select the activity and update the last end time
				selectedActivities.add(activity);
				lastEndTime = activity.end;
			}
		}
		return selectedActivities;
	}

	public static void main(String[] args) {
		List<Activity> activities = new ArrayList<>();
		activities.add(new Activity(1, 4));
		activities.add(new Activity(3, 5));
		activities.add(new Activity(0, 6));
		activities.add(new Activity(5, 7));
		activities.add(new Activity(8, 9));
		activities.add(new Activity(5, 9));

		List<Activity> result = selectActivities(activities);
		System.out.println("Selected activities:");
		for (Activity activity : result) {
			System.out.println("Activity: Start = " + activity.start + ", End = " + activity.end);
		}
	}
}
