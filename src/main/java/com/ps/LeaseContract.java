package com.ps;

import java.time.LocalDate;

public abstract class LeaseContract extends Contract {
    private double endingValue;
    private double leasingFee;

    public LeaseContract(LocalDate date, String customerName, String customerEmail, boolean vehicleSold,
                         Vehicle vehicle, double endingValue, double leasingFee) {
        super(date, customerName, customerEmail, vehicleSold, vehicle);
        this.endingValue = endingValue;
        this.leasingFee = leasingFee;
    }

    public double getEndingValue() {

        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeasingFee() {
        return leasingFee;
    }

    public void setLeasingFee(double leasingFee) {
        this.leasingFee = leasingFee;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;// there is no option for buying out in leasing
    }
}
