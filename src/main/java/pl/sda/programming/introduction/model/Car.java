package pl.sda.programming.introduction.model;

// by default if there is no visibility modifier
// class is package visible

// public is visible everywhere
public class Car {
    // static fields
    public static final String STATUS_COMPANY  = "company";
    public static final String STATUS_PERSONAL = "personal";

    // immutable class fields
    private final String type;
    private final String model;
    private final float engine;
    private final int weight;
    private final String vin;

    // mutable fields
    private int distance = 0;
    private String registrationNumber;
    private String status;

    // constructors

    // default constructor
//    public Car() {
//    }

    public Car(String type, String model, float engine, int weight, String vin) {
        this.type = type;
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public float getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getVin() {
        return vin;
    }

    public int getDistance() {
        return distance;
    }

    public void addDistance(int km) {
        if (km > 0) {
            distance += km;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPower() {
        return engine * 1000 / weight;
    }
}
