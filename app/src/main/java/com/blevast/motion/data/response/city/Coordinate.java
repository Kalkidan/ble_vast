package com.blevast.motion.data.response.city;

public class Coordinate {

    private float lat;
    private float lon;

    /**
     * @param lat
     * @param lon
     */
    public Coordinate(long lat, long lon){
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
