package com.alarm.core;

import java.util.Map;

/**
 * Get the alarm status by its trackname
 */
public class GetAlarm {
    private final long id;
    private final Boolean alarmStatus;
    private final String message;

    public GetAlarm(long id, String trackName, String content) {
        this.id = id;
        this.message = content;

        AffectTracks tracks;
        tracks = Tracks.getInstance();

        Map<String, Boolean> alarms = tracks.getAlarms();

        this.alarmStatus = this.alarmStatus(alarms, trackName);
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getAlarmStatus(){
        return this.alarmStatus;
    }

    /**
     * Search for alarm in alarms list.
     * @param alarms list of alarms map string boolean
     * @param trackName track name
     * @return boolean containing the status of the alarm null if the alarm does not exists.
     */
    private Boolean alarmStatus(Map<String, Boolean> alarms ,String trackName){
        Boolean alarmStatus = null;
        for (Map.Entry<String, Boolean> alarm : alarms.entrySet()){
            if (alarm.getKey().equals(trackName)){
                alarmStatus = alarm.getValue();
            }
        }
        return alarmStatus;
    }
}

