package com.alarm.core;

/**
 * Raise the alarm in the system
 */
public class RaiseAlarm {

    private final long id;
    private final String message;

    public RaiseAlarm(long id, String trackName, String content) {
        this.id = id;
        this.message = content;

        AffectTracks tracks;
        tracks = Tracks.getInstance();

        tracks.setAlarm(trackName);

    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}