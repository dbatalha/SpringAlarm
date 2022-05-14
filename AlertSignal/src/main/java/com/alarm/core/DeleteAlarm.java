package com.alarm.core;

public class DeleteAlarm {

    private final long id;
    private final String message;

    public DeleteAlarm(long id, String trackName, String content) {
        this.id = id;
        this.message = content;

        AffectTracks tracks;
        tracks = Tracks.getInstance();

        tracks.deleteAlarm(trackName);
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}
