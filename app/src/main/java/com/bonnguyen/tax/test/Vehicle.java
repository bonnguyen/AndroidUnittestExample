package com.bonnguyen.tax.test;

/**
 * Created by nguyenbon on 10/18/16.
 */

public abstract class Vehicle {
    private String manufactory;
    private String model;
    private long registered;

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getRegistered() {
        return registered;
    }

    public void setRegistered(long registered) {
        this.registered = registered;
    }
}
