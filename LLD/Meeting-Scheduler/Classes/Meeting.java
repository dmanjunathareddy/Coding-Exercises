package com.softgroup.lld.meetingscheduler;

import java.util.List;

public class Meeting {
	private int meetingId;
	private List<String> participants;
	private String dateTime;

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public List<String> getParticipants() {
		return participants;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Meeting(int meetingId, List<String> participants, String dateTime) {
		super();
		this.meetingId = meetingId;
		this.participants = participants;
		this.dateTime = dateTime;
	}

}
