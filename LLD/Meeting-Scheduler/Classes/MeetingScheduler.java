package com.softgroup.lld.meetingscheduler;

public class MeetingScheduler {
    private MeetingRoomManager roomManager;
    private NotificationService notificationService;

    public MeetingScheduler(MeetingRoomManager roomManager, NotificationService notificationService) {
        this.roomManager = roomManager;
        this.notificationService = notificationService;
    }

    public boolean scheduleMeeting(Meeting meeting, int roomId) {
        if (roomManager.bookRoom(meeting, roomId)) {
            notificationService.notifyParticipants(meeting);
            return true;
        }
        return false;
    }
}
