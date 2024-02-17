package com.softgroup.dsa.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
	int startTime, endTime;

	public Activity(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

public class ActivitySelection {

	// Function to perform activity selection
	public static List<Activity> selectActivities(List<Activity> activities) {
		// Sort activities based on their end times
		Collections.sort(activities, Comparator.comparingInt(a -> a.endTime));

		List<Activity> selectedActivities = new ArrayList<>();
		selectedActivities.add(activities.get(0));

		// Iterate through the sorted activities
		for (int i = 1; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			Activity lastSelectedActivity = selectedActivities.get(selectedActivities.size() - 1);

			// If the current activity's start time is after the end time of the last
			// selected activity, select it
			if (currentActivity.startTime >= lastSelectedActivity.endTime) {
				selectedActivities.add(currentActivity);
			}
		}

		return selectedActivities;
	}

	public static void main(String[] args) {
		// Example usage
		List<Activity> activities = new ArrayList<>();
		activities.add(new Activity(1, 4));
		activities.add(new Activity(3, 5));
		activities.add(new Activity(0, 6));
		activities.add(new Activity(5, 7));
		activities.add(new Activity(3, 8));
		activities.add(new Activity(5, 9));
		activities.add(new Activity(6, 10));
		activities.add(new Activity(8, 11));
		activities.add(new Activity(8, 12));
		activities.add(new Activity(2, 13));
		activities.add(new Activity(12, 14));

		List<Activity> selectedActivities = selectActivities(activities);

		System.out.println("Selected activities:");
		for (Activity activity : selectedActivities) {
			System.out.println("[" + activity.startTime + ", " + activity.endTime + "]");
		}
	}
}
