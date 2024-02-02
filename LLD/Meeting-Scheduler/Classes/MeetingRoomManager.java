package com.softgroup.lld.meetingscheduler;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomManager {
    private Map<Integer, MeetingRoomCalendar> roomCalendars;

    public MeetingRoomManager() {
        this.roomCalendars = new HashMap<>();
    }

    public boolean bookRoom(Meeting meeting, int roomId) {
        if (roomCalendars.containsKey(roomId)) {
            return roomCalendars.get(roomId).bookTimeSlot(meeting);
        }
        return false;
    }

    public boolean unbookRoom(Meeting meeting, int roomId) {
        if (roomCalendars.containsKey(roomId)) {
            return roomCalendars.get(roomId).unbookTimeSlot(meeting);
        }
        return false;
    }

    public boolean isRoomAvailable(int roomId, String dateTime) {
        if (roomCalendars.containsKey(roomId)) {
            return roomCalendars.get(roomId).isTimeSlotAvailable(dateTime);
        }
        return true;
    }

    // Additional methods for managing and retrieving room information
}