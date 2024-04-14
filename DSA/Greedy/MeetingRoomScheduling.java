package com.softgroup.dsa.greedy;

import java.util.*;

class Meeting {
	int start, end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MeetingRoomScheduling {

	public static int maxMeetings(List<Meeting> meetings) {
		// Sort meetings by their end times
		meetings.sort((a, b) -> a.end - b.end);

		int maxMeetings = 0;
		int lastEndTime = -1;

		// Iterate through sorted meetings
		for (Meeting meeting : meetings) {
			// If the meeting starts after the last selected meeting ended
			if (meeting.start >= lastEndTime) {
				// Select this meeting
				maxMeetings++;
				lastEndTime = meeting.end;
			}
		}

		return maxMeetings;
	}

	public static void main(String[] args) {
		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting(1, 3));
		meetings.add(new Meeting(2, 4));
		meetings.add(new Meeting(3, 5));
		meetings.add(new Meeting(6, 8));
		meetings.add(new Meeting(8, 10));

		int max = maxMeetings(meetings);
		System.out.println("Maximum number of non-overlapping meetings: " + max);
	}
}
