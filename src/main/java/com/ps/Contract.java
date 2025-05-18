package com.ps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Contract {
    private ArrayList<Vehicle> sale;

    private LocalDate date;
    private String customerName;
    private String customerEmail;
    private boolean vehicleSold;
    private Vehicle vehicle;

    public Contract(LocalDate date, String customerName, String customerEmail, boolean vehicleSold, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public DateTimeFormatter getDate() {
        return DateTimeFormatter.ofPattern("MM/dd/yyyy");
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public ArrayList<Vehicle> getVehicle(int vin) {
        ArrayList<Vehicle> getVehicle = new ArrayList<>();
        for (Vehicle vehicle:sale){
            if (vehicle.getVin()==vin){
                getVehicle.add(vehicle);
            }
        }
        return getVehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
