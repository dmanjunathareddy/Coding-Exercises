package com.softgroup.lld.meetingscheduler;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomCalendar {
	private Map<String, Boolean> timeSlots; // Date-time to availability mapping

	public MeetingRoomCalendar() {
		this.timeSlots = new HashMap<>();
	}

	public boolean bookTimeSlot(Meeting meeting) {
		// Logic to book the time slot
		return false;

	}

	public boolean unbookTimeSlot(Meeting meeting) {
		// Logic to unbook the time slot
		return false;

	}

	public boolean isTimeSlotAvailable(String dateTime) {
		// Logic to check if the time slot is available
		return false;

	}
}