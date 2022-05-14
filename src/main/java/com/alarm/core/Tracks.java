package com.alarm.core;

/**
 * Singleton class
 */
public class Tracks {

    private static AffectTracks affectTracks;

    /**
     * If affected tracks is already instanciated.
     * @return the affectTracks instance.
     */
    public static AffectTracks getInstance(){

        if(affectTracks == null) {
            affectTracks = new AffectTracks();
        }

        return affectTracks;

    }
}
