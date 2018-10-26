package com.blevast.motion.data.response.city;


import java.util.List;

public class WeatherCityResponse {

    private Coordinate coord;
    private List<Weather> weather;
    private String stations;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private System sys;
    private long id;
    private String name;
    private int cod;

   public WeatherCityResponse(Coordinate coord){
       this.coord = coord;
   }

    public Coordinate getCoord() {
        return coord;
    }

   /*   public WeatherCityResponse(Coordinate coordinate,
                               List<Weather> weatherList,
                               String stations,
                               Main main,
                               int visibility,
                               Wind wind,
                               Clouds clouds,
                               long dt,
                               System system,
                               long id,
                               String name,
                               int cod){
        this.coordinate = coordinate;
        this.weatherList = weatherList;
        this.stations = stations;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.system = system;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }*/

    /*public int getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getDt() {
        return dt;
    }

    public int getVisibility() {
        return visibility;
    }

    public String getStations() {
        return stations;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public Main getMain() {
        return main;
    }

    public System getSystem() {
        return system;
    }

    public Wind getWind() {
        return wind;
    }*/
}
