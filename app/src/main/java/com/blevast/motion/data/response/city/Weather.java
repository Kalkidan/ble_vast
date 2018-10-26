package com.blevast.motion.data.response.city;

import com.squareup.moshi.Json;

public class Weather {


    @Json(name = "id")
    private String id;
    @Json(name = "main")
    private String main;
    @Json(name = "description")
    private String description;
    @Json(name = "icon")
    private String icon;

    /**
     * @param description
     * @param icon
     * @param id
     * @param main
     */
    public Weather(String id, String main, String description, String icon){
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public String getMain() {
        return main;
    }
}
