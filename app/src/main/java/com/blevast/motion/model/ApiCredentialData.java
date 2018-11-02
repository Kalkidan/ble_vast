package com.blevast.motion.model;

public class ApiCredentialData extends BaseData{

    private String apiKey;
    private String cityName;

    /**
     * @param cityName
     * @param apiKey
     *
     */
    public ApiCredentialData(String apiKey, String cityName){
        this.apiKey = apiKey;
        this.cityName = cityName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCityName() {
        return cityName;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
