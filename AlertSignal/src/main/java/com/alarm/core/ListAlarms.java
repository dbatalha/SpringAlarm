package com.alarm.core;

import java.util.Map;

/**
 * List all the alarms
 */
public class ListAlarms {
    private final long id;
    private final Map<String, Boolean> alarms;
    private final String message;

    public ListAlarms(long id, String content) {
        this.id = id;
        this.message = content;

        AffectTracks tracks;
        tracks = Tracks.getInstance();

        this.alarms = tracks.getAlarms();
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, Boolean> getAlarms(){
        return this.alarms;
    }
}
