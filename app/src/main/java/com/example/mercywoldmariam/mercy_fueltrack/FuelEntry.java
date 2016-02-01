package com.example.mercywoldmariam.mercy_fueltrack;


/**
 * Created by mercywoldmariam on 2016-01-22.
 */
public abstract class FuelEntry {
    protected String date;
    protected String station;
    protected float odometerReading;
    protected String fuelGrade;
    protected float fuelAmount;
    protected float fuelUnitCost;

    public FuelEntry(String date, String station, float odometerReading, String fuelGrade,
                     float fuelAmount, float fuelUnitCost) {
        this.date = date;
        this.station = station;
        this.odometerReading = odometerReading;
        this.fuelGrade = fuelGrade;
        this.fuelAmount = fuelAmount;
        this.fuelUnitCost = fuelUnitCost;

    }

    public FuelEntry(String date) {
        this.date = date;
    }

    public FuelEntry(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }


    /* All of the getters*/
    public String getDate() {
        return date;
    }

    public String getStation() {
        return station;
    }

    public float getOdometerReading() {
        return odometerReading;
    }

    public String getFuelGrade() {
        return fuelGrade;
    }

    public float getFuelAmount() {
        return fuelAmount;
    }

    public float getFuelUnitCost() {
        return fuelUnitCost;
    }

    /* All of the setters*/
    public void setDate(String date) {
        this.date = date;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setOdometerReading(float odometerReading) {
        this.odometerReading = odometerReading;
    }

    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade;
    }

    public void setFuelAmount(float fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelUnitCost(float fuelUnitCost) {
        this.fuelUnitCost = fuelUnitCost;
    }

    /* toString() function called in FuelTracking*/
    @Override
    public String toString(){
        return date + " | " + station + " | " + this.odometerReading + " | " + fuelGrade + " | "  + this.fuelAmount + " | " + this.fuelUnitCost;
        //return message;
    }

}
