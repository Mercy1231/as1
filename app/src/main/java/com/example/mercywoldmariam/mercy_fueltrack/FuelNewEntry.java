package com.example.mercywoldmariam.mercy_fueltrack;

import java.util.Date;

/**
 * Created by mercywoldmariam on 2016-01-25.
 */
public class FuelNewEntry extends FuelEntry implements FuelEntryLogging {

    public FuelNewEntry(String date, String station, float odometerReading, String fuelGrade,
                     float fuelAmount, float fuelUnitCost) {
        super(date);
    }

    @Override
    public String getFuelGrade() {
        return super.getFuelGrade();
    }

}

