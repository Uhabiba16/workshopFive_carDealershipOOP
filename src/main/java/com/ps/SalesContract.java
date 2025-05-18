package com.ps;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class SalesContract extends Contract {

    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;

    public SalesContract(LocalDate date, String customerName, String customerEmail, boolean vehicleSold,
                         Vehicle vehicle, double salesTax, double recordingFee, double processingFee, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold, vehicle);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        return 0;// gets the total price if veh is sold
    }

    @Override
    public double getMonthlyPayment() {
        return 0;// gets the monthly payment for financing
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
}
