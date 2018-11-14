package com.blevast.motion.model;

public class SubscriptionCredentials extends BaseData {

    private String userName;
    private String subscriptionName;

    public SubscriptionCredentials(String userName, String subscriptionName) {
        this.userName = userName;
        this.subscriptionName = subscriptionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
}
