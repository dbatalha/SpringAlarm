package com.alarm.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Affect alarms to tracks.
 */
public class AffectTracks {

    Map<String, Boolean> tracks;

    public AffectTracks(){
        this.tracks = new HashMap<>();
    }

    /**
     * This method raise the alarm in the system.
     * @param trackName track where the alarm were raised.
     */
    public void setAlarm(String trackName){
        this.tracks.put(trackName, true);
    }

    /**
     * This method clear the alarm in the system.
     * @param trackName track where the alarm were cleared.
     */
    public void clearAlarm(String trackName){
        this.tracks.put(trackName, false);
    }

    /**
     * This method remove the alarm in the system.
     * @param trackName the track name to be removed.
     */
    public void deleteAlarm(String trackName){
        this.tracks.remove(trackName);
    }

    /**
     * List all available alarms in the system.
     * @return return a map with all raised and cleared alarms.
     */
    public Map<String, Boolean> getAlarms(){
        return this.tracks;
    }

}
