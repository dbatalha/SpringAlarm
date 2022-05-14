package com.alarm.core;

/**
 * Class used to clear the alarm
 */
public class ClearAlarm {

    private final long id;
    private final String message;

    public ClearAlarm(long id, String trackName, String content) {
        this.id = id;
        this.message = content;

        AffectTracks tracks;
        tracks = Tracks.getInstance();

        tracks.clearAlarm(trackName);
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }
}
