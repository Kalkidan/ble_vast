package com.blevast.motion.data.response.city;

import com.squareup.moshi.Json;

public class System {

    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    public System(int type, int id, double message, String country, long sunrise, long sunset){
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public double getMessage() {
        return message;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public String getCountry() {
        return country;
    }
}
