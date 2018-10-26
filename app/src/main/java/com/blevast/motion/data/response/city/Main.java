package com.blevast.motion.data.response.city;

import com.squareup.moshi.Json;

public class Main {

    private long tem;
    private int pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;

    public Main(long tem, int pressure, int humidity, int temp_min, int temp_max){
        this.tem = tem;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public long getTemprature() {
        return tem;
    }
}
