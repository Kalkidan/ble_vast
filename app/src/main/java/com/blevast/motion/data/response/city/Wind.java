package com.blevast.motion.data.response.city;

import com.squareup.moshi.Json;

public class Wind {

    private double speed;
    private double deg;

    public Wind(double speed, double degree){
        this.speed = speed;
        this.deg = degree;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDegree() {
        return deg;
    }
}
